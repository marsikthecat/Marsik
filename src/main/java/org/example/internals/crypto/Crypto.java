package org.example.internals.crypto;

import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.macs.KMAC;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;
import org.example.internals.Sys;
import org.example.internals.datastructures.MarsikString;
import javax.crypto.*;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Crypto {

  private static final int GCM_NONCE_LENGTH = 12;
  private static final int GCM_TAG_LENGTH = 128;
  private static int SALT_LENGTH;
  private static final int KEY_SIZE = 64;
  private static SecureRandom secureRandom;
  private static CryptoMode cryptoMode = CryptoMode.NORMAL;

  public static void setMode(CryptoMode cryptoMode) {
    if (cryptoMode == CryptoMode.NORMAL) {
      SALT_LENGTH = 32;
      secureRandom = new SecureRandom();
    }
    if (cryptoMode == CryptoMode.HARDCORE) {
      Sys.printWarning("Hardcore mode has just been activated! \n" +
              "This method should be treated with caution!");
      SALT_LENGTH = 64;
      try {
        secureRandom = SecureRandom.getInstanceStrong();
      } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
      }
    }
    if (cryptoMode == CryptoMode.EXTREME) {
      SALT_LENGTH = 128;
      Sys.printError("////   EXTREME WARNING   ////");
      Sys.printError("EXTREME_MODE has just been activated!");
      Sys.printError("You have just activated the apocalyptic Mode!\n" +
              "This Mode uses extreme amount of RAM and CPU and can destroy your PC!!!");
      try {
        secureRandom = SecureRandom.getInstanceStrong();
      } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
      }
    }
    Crypto.cryptoMode = cryptoMode;
  }

  public static CryptoData generateKey() {
    if (cryptoMode == null) {
      throw new IllegalStateException("You need to set the Mode before using it");
    }
    byte[] salt = new byte[SALT_LENGTH];
    secureRandom.nextBytes(salt);
    if (cryptoMode == CryptoMode.NORMAL) {
      SecretKey key = deriveKey(salt);
      return new CryptoData().setSalt(salt).setSecretKey(key);
    } else {
      return generateKeyWithArgon(new char[]{'a', 'd', 'i', 'e', 'd'}, salt);
    }
  }

  private static SecretKey deriveKey(byte[] salt) {
    try {
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
      char[] password = "secretPassword1234567890".toCharArray(); //TODO: Store this securely
      KeySpec spec = new PBEKeySpec(password, salt, 1000000, 256);
      SecretKey tmp = factory.generateSecret(spec);
      return new SecretKeySpec(tmp.getEncoded(), "AES");
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
  }

  private static CryptoData generateKeyWithArgon(char[] password, byte[] salt) {
    int parallelism = cryptoMode == CryptoMode.HARDCORE ? 4 : 8;
    int memory = cryptoMode == CryptoMode.HARDCORE ? 262144 : 1048576;
    int iterations = cryptoMode == CryptoMode.HARDCORE ? 12 : 64;
    Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
            .withSalt(salt)
            .withParallelism(parallelism)
            .withMemoryAsKB(memory)
            .withIterations(iterations);

    Argon2BytesGenerator generator = new Argon2BytesGenerator();
    generator.init(builder.build());
    byte[] result = new byte[KEY_SIZE];
    generator.generateBytes(password, result);
    Arrays.fill(password, '\0');
    return new CryptoData().setSalt(salt).setArgonKey(result);
  }

  public static CryptoData encrypt(MarsikString plainTextWrapper, CryptoData cryptoData) {
    String plainText = plainTextWrapper.toJavaString();
    if (cryptoMode == CryptoMode.NORMAL) {
      try {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = generateIV();
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, cryptoData.getSecretKey(), spec);
        cryptoData.destroyKey();
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return cryptoData.setEncrypted(cipherText).setIv(iv);
      } catch (NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
               NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    }
    else if (cryptoMode == CryptoMode.HARDCORE) {
      byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
      byte[] hmacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
      byte[] encrypted = aes(plainText, cryptoData, aesKey);
      byte[] hmac = computeHMAC(encrypted, hmacKey);
      return cryptoData.setHmac(hmac).setEncrypted(encrypted);
    } else {
      byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
      byte[] chaChaKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
      byte[] kMacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 64, 128);
      byte[] encrypted = aes(plainText, cryptoData, aesKey);
      byte[] bytes = chaCha(chaChaKey, encrypted);
      byte[] tag = computeKMAC(kMacKey, bytes);
      byte[] tagAndPayload = new byte[tag.length + bytes.length];
      System.arraycopy(tag, 0, tagAndPayload, 0, tag.length);
      System.arraycopy(bytes, 0, tagAndPayload, tag.length, bytes.length);
      return cryptoData.setKMac(tagAndPayload);
    }
  }

  private static byte[] aes(String plainText, CryptoData cryptoData, byte[] aesKey) {
    try {
      SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      byte[] iv = generateIV();
      cryptoData.setIv(iv);
      GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
      cipher.init(Cipher.ENCRYPT_MODE, keySpec, spec);
      byte[] cipherText = cipher.doFinal(plainText.getBytes());
      byte[] salt = cryptoData.getSalt();
      byte[] encrypted = new byte[salt.length + iv.length + cipherText.length];
      System.arraycopy(salt, 0, encrypted, 0, salt.length);
      System.arraycopy(iv, 0, encrypted, salt.length, iv.length);
      System.arraycopy(cipherText, 0, encrypted, salt.length + iv.length, cipherText.length);
      return encrypted;
    } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
             InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  public static MarsikString decrypt(CryptoData cryptoData) {
    if (cryptoMode == CryptoMode.NORMAL) {
      try {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = cryptoData.getIv();
        byte[] cipherText = cryptoData.getEncrypted();
        byte[] salt = cryptoData.getSalt();
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, deriveKey(salt), spec);
        String decrypted = new String(cipher.doFinal(cipherText));
        return new MarsikString(decrypted);
      } catch (InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException |
               NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    }
    else if (cryptoMode == CryptoMode.HARDCORE) {
      try {
        byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
        byte[] hmacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
        byte[] encrypted = cryptoData.getEncrypted();
        byte[] expectedHmac = cryptoData.getHmac();
        byte[] actualHmac = computeHMAC(encrypted, hmacKey);
        if (!MessageDigest.isEqual(expectedHmac, actualHmac)) {
          throw new SecurityException("HMAC verification failed. Data may have been tampered with.");
        }
        byte[] salt = cryptoData.getSalt();
        int saltLength = salt.length;
        byte[] cipherText = Arrays.copyOfRange(encrypted, saltLength + GCM_NONCE_LENGTH, encrypted.length);

        cryptoData.destroyArgonKey();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, cryptoData.getIv());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, spec);
        byte[] plainBytes = cipher.doFinal(cipherText);
        String decrypted = new String(plainBytes);
        return new MarsikString(decrypted);
      } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
               NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    } else {
      try {
        byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
        byte[] chaChaKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
        byte[] kMacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 64, 128);

        int kMacLength = new KMAC(128, new byte[0]).getMacSize();
        if (cryptoData.getKMac().length < kMacLength)
          throw new IllegalArgumentException("Input too short");

        byte[] expectedKMAC = Arrays.copyOfRange(cryptoData.getKMac(), 0, kMacLength);
        byte[] actualEncrypted = Arrays.copyOfRange(cryptoData.getKMac(), kMacLength, cryptoData.getKMac().length);
        byte[] actualKMAC = computeKMAC(kMacKey, actualEncrypted);
        if (!MessageDigest.isEqual(expectedKMAC, actualKMAC)) {
          throw new SecurityException("KMac verification failed");
        }

        byte[] nonce = Arrays.copyOfRange(actualEncrypted, 0, 12);
        byte[] chaChaCiphertext = Arrays.copyOfRange(actualEncrypted, 12, actualEncrypted.length);

        Cipher chachaCipher = Cipher.getInstance("ChaCha20");
        SecretKey chachaSecretKey = new SecretKeySpec(chaChaKey, "ChaCha20");
        ChaCha20ParameterSpec chaChaParamSpec = new ChaCha20ParameterSpec(nonce, 1);
        chachaCipher.init(Cipher.DECRYPT_MODE, chachaSecretKey, chaChaParamSpec);
        byte[] decryptedChaCha = chachaCipher.doFinal(chaChaCiphertext);

        byte[] salt = Arrays.copyOfRange(decryptedChaCha, 0, cryptoData.getSalt().length);
        byte[] iv = Arrays.copyOfRange(decryptedChaCha, salt.length, salt.length + GCM_NONCE_LENGTH);
        byte[] aesCipherText = Arrays.copyOfRange(decryptedChaCha, salt.length + GCM_NONCE_LENGTH, decryptedChaCha.length);

        Cipher aesCipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec aesKeySpec = new SecretKeySpec(aesKey, "AES");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        aesCipher.init(Cipher.DECRYPT_MODE, aesKeySpec, gcmSpec);
        byte[] plainBytes = aesCipher.doFinal(aesCipherText);
        String decrypted = new String(plainBytes, StandardCharsets.UTF_8);
        return new MarsikString(decrypted);
      } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
               InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static byte[] generateIV() {
    byte[] iv = new byte[Crypto.GCM_NONCE_LENGTH];
    secureRandom.nextBytes(iv);
    return iv;
  }

  private static byte[] computeHMAC(byte[] data, byte[] hmacKey) {
    try {
      Mac hmac = Mac.getInstance("HmacSHA512");
      SecretKeySpec keySpec = new SecretKeySpec(hmacKey, "HmacSHA512");
      hmac.init(keySpec);
      return hmac.doFinal(data);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  private static byte[] chaCha(byte[] key, byte[] encrypted) {
    try {
      byte[] nonce = new byte[12];
      secureRandom.nextBytes(nonce);
      Cipher cipher = Cipher.getInstance("ChaCha20");
      SecretKey secretKey = new SecretKeySpec(key, "ChaCha20");
      ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, 1);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
      byte[] ciphertext = cipher.doFinal(encrypted);
      byte[] output = new byte[nonce.length + ciphertext.length];
      System.arraycopy(nonce, 0, output, 0, nonce.length);
      System.arraycopy(ciphertext, 0, output, nonce.length, ciphertext.length);
      return output;
    } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
             InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  private static byte[] computeKMAC(byte[] key, byte[] data) {
    KMAC kmac = new KMAC(128, new byte[0]);
    kmac.init(new KeyParameter(key));
    kmac.update(data, 0, data.length);
    byte[] output = new byte[kmac.getMacSize()];
    kmac.doFinal(output, 0);
    return output;
  }


  public static String sha256(String stuffToGetHashed) {
    try {
      MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
      byte[] hash256 = sha256.digest(stuffToGetHashed.getBytes());
      return bytesToHex(hash256);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

  }

  public static String sha512(String stuffToGetHashed) {
    try {
      MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
      byte[] hash512 = sha512.digest(stuffToGetHashed.getBytes());
      return bytesToHex(hash512);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

  }

  public static String sha3_256(String stuffToGetHashed) {
    try {
      MessageDigest sha3_256 = MessageDigest.getInstance("SHA3-256");
      byte[] hash3_256 = sha3_256.digest(stuffToGetHashed.getBytes());
      return bytesToHex(hash3_256);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static String sha3_384(String stuffToGetHashed) {
    try {
      MessageDigest sha3_384 = MessageDigest.getInstance("SHA3-384");
      byte[] hash3_384 = sha3_384.digest(stuffToGetHashed.getBytes());
      return bytesToHex(hash3_384);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static String sha3_512(String stuffToGetHashed) {
    try {
      MessageDigest sha3_512 = MessageDigest.getInstance("SHA3-512");
      byte[] hash3_512 = sha3_512.digest(stuffToGetHashed.getBytes());
      return bytesToHex(hash3_512);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static String shake_128(String stuffToGetHashed) {
    org.bouncycastle.crypto.digests.SHAKEDigest shake128 = new org.bouncycastle.crypto.digests.SHAKEDigest(128);
    shake128.update(stuffToGetHashed.getBytes(), 0, stuffToGetHashed.getBytes().length);
    byte[] shake128Output = new byte[64];
    shake128.doFinal(shake128Output, 0, shake128Output.length);
    return bytesToHex(shake128Output);
  }

  public static String shake_256(String stuffToGetHashed) {
    SHAKEDigest shake256 = new SHAKEDigest(256);
    shake256.update(stuffToGetHashed.getBytes(), 0, stuffToGetHashed.getBytes().length);
    byte[] shake256Output = new byte[64];
    shake256.doFinal(shake256Output, 0, shake256Output.length);
    return bytesToHex(shake256Output);
  }

  public static String blake2b(String stuffToGetHashed) {
    byte[] input = stuffToGetHashed.getBytes();
    Blake2bDigest digest = new Blake2bDigest(64);
    digest.update(input, 0, input.length);
    byte[] out = new byte[digest.getDigestSize()];
    digest.doFinal(out, 0);
    return Hex.toHexString(out);
  }

  public static String blake2b(String stuffToGetHashed, String keyString) {
    byte[] key = keyString.getBytes();
    Blake2bDigest keyed = new Blake2bDigest(key, 64, null, null);
    keyed.update(stuffToGetHashed.getBytes(), 0, stuffToGetHashed.length());
    byte[] outKeyed = new byte[keyed.getDigestSize()];
    keyed.doFinal(outKeyed, 0);
    return Hex.toHexString(outKeyed);
  }

  /**
   * Important: return value contains 2 elements: salt and the hash encoded in String format.
   */
  public static String[] argon2(String stuffToGetHashed) {
    byte[] salt = new byte[16];
    new SecureRandom().nextBytes(salt);

    Argon2Parameters params = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
            .withSalt(salt)
            .withIterations(3)
            .withMemoryAsKB(65536)
            .withParallelism(1)
            .build();

    Argon2BytesGenerator gen = new Argon2BytesGenerator();
    gen.init(params);

    byte[] hash = new byte[32];
    gen.generateBytes(stuffToGetHashed.toCharArray(), hash, 0, hash.length);
    String saltString = Base64.getEncoder().encodeToString(salt);
    String hashString = Base64.getEncoder().encodeToString(hash);
    return new String[]{saltString, hashString};
  }

  public static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
}