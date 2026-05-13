package org.example.internals.crypto;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.macs.KMAC;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;
import org.example.internals.Sys;

/**
 * A utility class for cryptographic operations with multiple security modes.
 * Supports AES-GCM encryption in NORMAL mode, and stronger Argon2 + AES/ChaCha + HMAC/KMAC
 * schemes in HARDCORE and EXTREME modes.
 * Modes:
 * <ul>
 *   <li>NORMAL: standard AES-GCM with PBKDF2-derived key</li>
 *   <li>HARDCORE: Argon2 key derivation with AES-GCM + HMAC</li>
 *   <li>EXTREME: Argon2 key derivation with AES-GCM + ChaCha + KMAC</li>
 * </ul>
 */
public class Crypto {

  private static final int GCM_NONCE_LENGTH = 12;
  private static final int GCM_TAG_LENGTH = 128;
  private static int SALT_LENGTH = 32;
  private static final int KEY_SIZE = 64;
  private static SecureRandom secureRandom = new SecureRandom();
  private static CryptoMode cryptoMode = CryptoMode.NORMAL;

  /**
   * Sets the cryptographic mode for key generation and encryption.
   * Must be called before generateKey().
   *
   * @param cryptoMode the desired security mode (NORMAL, HARDCORE, EXTREME)
   */
  public static void setMode(CryptoMode cryptoMode) {
    if (cryptoMode == CryptoMode.NORMAL) {
      SALT_LENGTH = 32;
      secureRandom = new SecureRandom();
    }
    if (cryptoMode == CryptoMode.HARDCORE) {
      Sys.printWarning("Hardcore mode has just been activated! \n"
              + "This method should be treated with caution!");
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
      Sys.printError("You have just activated the apocalyptic Mode!\n"
              + "This Mode uses extreme amount of RAM and CPU and can destroy your PC!!!");
      try {
        secureRandom = SecureRandom.getInstanceStrong();
      } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
      }
    }
    Crypto.cryptoMode = cryptoMode;
  }

  /**
   * Generates a cryptographic key based on the current mode.
   * Uses PBKDF2 for NORMAL mode or Argon2 for HARDCORE/EXTREME.
   *
   * @return a CryptoData object containing the key and salt
   */
  public static CryptoData generateKey() {
    byte[] salt = new byte[SALT_LENGTH];
    secureRandom.nextBytes(salt);
    if (cryptoMode == CryptoMode.NORMAL) {
      SecretKey key = deriveKey(salt);
      return new CryptoData().setSalt(salt).setSecretKey(key);
    } else {
      return generateKeyWithArgon(new char[]{'a', 'd', 'i', 'e', 'd'}, salt);
    }
  }

  /**
   * Derives an AES secret key from the given salt using PBKDF2 with HMAC-SHA512.
   * Only used in NORMAL mode.
   *
   * @param salt the salt to use for key derivation
   * @return the derived AES SecretKey
   */
  private static SecretKey deriveKey(byte[] salt) {
    try {
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
      // TODO: Store this securely
      char[] password = "secretPassword1234567890".toCharArray();
      KeySpec spec = new PBEKeySpec(password, salt, 1000000, 256);
      SecretKey tmp = factory.generateSecret(spec);
      return new SecretKeySpec(tmp.getEncoded(), "AES");
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Generates a key using Argon2 with configurable parameters based on the current mode.
   * Returns CryptoData containing the Argon2 key and salt.
   *
   * @param password the password to derive the key from
   * @param salt     the salt to use
   * @return a CryptoData object containing the key and salt
   */
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

  /**
   * Encrypts the given plaintext using the provided CryptoData and the currently set mode.
   *
   * @param plainText the plaintext wrapped in a String
   * @param cryptoData       the CryptoData containing the key material
   * @return updated CryptoData with encrypted payload and associated metadata
   */
  public static CryptoData encrypt(String plainText, CryptoData cryptoData) {
    if (cryptoMode == CryptoMode.NORMAL) {
      try {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = generateIv();
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, cryptoData.getSecretKey(), spec);
        cryptoData.destroyKey();
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return cryptoData.setEncrypted(cipherText).setIv(iv);
      } catch (NoSuchPaddingException | InvalidAlgorithmParameterException
               | IllegalBlockSizeException | NoSuchAlgorithmException
               | BadPaddingException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    } else if (cryptoMode == CryptoMode.HARDCORE) {
      byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
      byte[] hmacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
      byte[] encrypted = aes(plainText, cryptoData, aesKey);
      byte[] hmac = computeHmac(encrypted, hmacKey);
      return cryptoData.setHmac(hmac).setEncrypted(encrypted);
    } else {
      byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
      byte[] chaChaKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
      byte[] kmacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 64, 128);
      byte[] encrypted = aes(plainText, cryptoData, aesKey);
      byte[] bytes = chaCha(chaChaKey, encrypted);
      byte[] tag = computeKmac(kmacKey, bytes);
      byte[] tagAndPayload = new byte[tag.length + bytes.length];
      System.arraycopy(tag, 0, tagAndPayload, 0, tag.length);
      System.arraycopy(bytes, 0, tagAndPayload, tag.length, bytes.length);
      return cryptoData.setKmac(tagAndPayload);
    }
  }

  /**
   * Performs AES-GCM encryption using the given AES key and plaintext.
   * Prepares the output by concatenating salt, IV, and ciphertext.
   *
   * @param plainText  the plaintext to encrypt
   * @param cryptoData the CryptoData containing salt and IV
   * @param aesKey     the AES key to use
   * @return byte array containing salt + IV + ciphertext
   */
  private static byte[] aes(String plainText, CryptoData cryptoData, byte[] aesKey) {
    try {
      SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      byte[] iv = generateIv();
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
    } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
             | InvalidAlgorithmParameterException | BadPaddingException
             | InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Decrypts data encrypted with Crypto.encrypt() using the mode stored in Crypto.
   * Supports NORMAL (AES-GCM), HARDCORE (Argon2 + AES-GCM + HMAC),
   * and EXTREME (Argon2 + AES-GCM + ChaCha + KMAC).
   *
   * @param cryptoData the CryptoData object containing encrypted data, keys, IVs, salts, and MACs
   * @return decrypted plaintext wrapped in a MarsikString
   * @throws SecurityException if HMAC/KMAC verification fails
   * @throws RuntimeException for cryptographic errors
   */
  public static String decrypt(CryptoData cryptoData) {
    if (cryptoMode == CryptoMode.NORMAL) {
      try {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = cryptoData.getIv();
        byte[] cipherText = cryptoData.getEncrypted();
        byte[] salt = cryptoData.getSalt();
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, deriveKey(salt), spec);
        return new String(cipher.doFinal(cipherText));
      } catch (InvalidAlgorithmParameterException | BadPaddingException
               | IllegalBlockSizeException | NoSuchPaddingException
               | NoSuchAlgorithmException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    } else if (cryptoMode == CryptoMode.HARDCORE) {
      try {
        byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
        byte[] hmacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
        byte[] encrypted = cryptoData.getEncrypted();
        byte[] expectedHmac = cryptoData.getHmac();
        byte[] actualHmac = computeHmac(encrypted, hmacKey);
        if (!MessageDigest.isEqual(expectedHmac, actualHmac)) {
          throw new SecurityException("HMAC verification failed. "
                  + "Data may have been tampered with.");
        }
        byte[] salt = cryptoData.getSalt();
        int saltLength = salt.length;
        byte[] cipherText = Arrays.copyOfRange(encrypted, saltLength
                + GCM_NONCE_LENGTH, encrypted.length);

        cryptoData.destroyArgonKey();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, cryptoData.getIv());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, spec);
        byte[] plainBytes = cipher.doFinal(cipherText);
        return new String(plainBytes);
      } catch (InvalidAlgorithmParameterException | NoSuchPaddingException
               | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException
               | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    } else {
      try {
        byte[] chaChaKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 32, 64);
        byte[] kmacKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 64, 128);

        int kmacLength = new KMAC(128, new byte[0]).getMacSize();
        if (cryptoData.getKmac().length < kmacLength) {
          throw new IllegalArgumentException("Input too short");
        }

        byte[] expectedKmac = Arrays.copyOfRange(cryptoData.getKmac(), 0, kmacLength);
        byte[] actualEncrypted = Arrays.copyOfRange(cryptoData.getKmac(), kmacLength,
                cryptoData.getKmac().length);
        byte[] actualKmac = computeKmac(kmacKey, actualEncrypted);
        if (!MessageDigest.isEqual(expectedKmac, actualKmac)) {
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
        byte[] iv = Arrays.copyOfRange(decryptedChaCha, salt.length, salt.length
                + GCM_NONCE_LENGTH);
        byte[] aesCipherText = Arrays.copyOfRange(decryptedChaCha, salt.length + GCM_NONCE_LENGTH,
                decryptedChaCha.length);

        byte[] aesKey = Arrays.copyOfRange(cryptoData.getArgonKey(), 0, 32);
        Cipher aesCipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec aesKeySpec = new SecretKeySpec(aesKey, "AES");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        aesCipher.init(Cipher.DECRYPT_MODE, aesKeySpec, gcmSpec);
        byte[] plainBytes = aesCipher.doFinal(aesCipherText);
        return new String(plainBytes, StandardCharsets.UTF_8);
      } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
               | InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * Generates a random IV for AES-GCM encryption.
   *
   * @return a 12-byte initialization vector
   */
  private static byte[] generateIv() {
    byte[] iv = new byte[Crypto.GCM_NONCE_LENGTH];
    secureRandom.nextBytes(iv);
    return iv;
  }

  /**
   * Computes HMAC-SHA512 for the given data using the provided key.
   *
   * @param data    the data to compute HMAC on
   * @param hmacKey the key to use for HMAC
   * @return HMAC-SHA512 byte array
   */
  private static byte[] computeHmac(byte[] data, byte[] hmacKey) {
    try {
      Mac hmac = Mac.getInstance("HmacSHA512");
      SecretKeySpec keySpec = new SecretKeySpec(hmacKey, "HmacSHA512");
      hmac.init(keySpec);
      return hmac.doFinal(data);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Encrypts data using ChaCha20 with a random 12-byte nonce.
   * Output is nonce concatenated with ciphertext.
   *
   * @param key       32-byte ChaCha key
   * @param encrypted plaintext bytes to encrypt
   * @return byte array containing nonce + ciphertext
   */
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
    } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
             | InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Computes KMAC128 for the given data using the provided key.
   *
   * @param key  the key to use
   * @param data the data to authenticate
   * @return KMAC byte array
   */
  private static byte[] computeKmac(byte[] key, byte[] data) {
    KMAC kmac = new KMAC(128, new byte[0]);
    kmac.init(new KeyParameter(key));
    kmac.update(data, 0, data.length);
    byte[] output = new byte[kmac.getMacSize()];
    kmac.doFinal(output, 0);
    return output;
  }

  /**
   * Computes SHA-256 hash of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHA-256 digest
   */
  public static String sha256(String input) {
    try {
      MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
      byte[] hash256 = sha256.digest(input.getBytes());
      return bytesToHex(hash256);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Computes SHA-512 hash of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHA-512 digest
   */
  public static String sha512(String input) {
    try {
      MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
      byte[] hash512 = sha512.digest(input.getBytes());
      return bytesToHex(hash512);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Computes SHA3-256 hash of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHA3-256 digest
   */
  public static String sha3Hash256(String input) {
    try {
      MessageDigest sha3Hash256 = MessageDigest.getInstance("SHA3-256");
      byte[] hash3Hash256 = sha3Hash256.digest(input.getBytes());
      return bytesToHex(hash3Hash256);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Computes SHA3-384 hash of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHA3-384 digest
   */
  public static String sha3Hash384(String input) {
    try {
      MessageDigest sha3Hash384 = MessageDigest.getInstance("SHA3-384");
      byte[] hash3Hash384 = sha3Hash384.digest(input.getBytes());
      return bytesToHex(hash3Hash384);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Computes SHA3-512 hash of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHA3-512 digest
   */
  public static String sha3Hash512(String input) {
    try {
      MessageDigest sha3Hash512 = MessageDigest.getInstance("SHA3-512");
      byte[] hash3Hash512 = sha3Hash512.digest(input.getBytes());
      return bytesToHex(hash3Hash512);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Computes SHAKE128 XOF digest of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHAKE128 digest (64 bytes)
   */
  public static String shakeHash128(String input) {
    org.bouncycastle.crypto.digests.SHAKEDigest shake128 =
            new org.bouncycastle.crypto.digests.SHAKEDigest(128);
    shake128.update(input.getBytes(), 0, input.getBytes().length);
    byte[] shake128Output = new byte[64];
    shake128.doFinal(shake128Output, 0, shake128Output.length);
    return bytesToHex(shake128Output);
  }

  /**
   * Computes SHAKE256 XOF digest of the input string.
   *
   * @param input input string
   * @return hexadecimal string of SHAKE256 digest (64 bytes)
   */
  public static String shakeHash256(String input) {
    SHAKEDigest shake256 = new SHAKEDigest(256);
    shake256.update(input.getBytes(), 0, input.getBytes().length);
    byte[] shake256Output = new byte[64];
    shake256.doFinal(shake256Output, 0, shake256Output.length);
    return bytesToHex(shake256Output);
  }

  /**
   * Computes BLAKE2b hash of the input string without key.
   *
   * @param input input string
   * @return hexadecimal string of BLAKE2b digest
   */
  public static String blake2b(String input) {
    byte[] byteInput = input.getBytes();
    Blake2bDigest digest = new Blake2bDigest(64);
    digest.update(byteInput, 0, byteInput.length);
    byte[] out = new byte[digest.getDigestSize()];
    digest.doFinal(out, 0);
    return Hex.toHexString(out);
  }

  /**
   * Computes keyed BLAKE2b hash of the input string.
   *
   * @param input     input string
   * @param keyString key string used for keyed BLAKE2b
   * @return hexadecimal string of keyed BLAKE2b digest
   */
  public static String blake2b(String input, String keyString) {
    byte[] key = keyString.getBytes();
    Blake2bDigest keyed = new Blake2bDigest(key, 64, null, null);
    keyed.update(input.getBytes(), 0, input.length());
    byte[] outKeyed = new byte[keyed.getDigestSize()];
    keyed.doFinal(outKeyed, 0);
    return Hex.toHexString(outKeyed);
  }

  /**
   * Computes Argon2id hash of the input string with a random 16-byte salt.
   * Returns an array containing the Base64-encoded salt and hash.
   *
   * @param input input string
   * @return array {saltBase64, hashBase64}
   */
  public static String[] argon2(String input) {
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
    gen.generateBytes(input.toCharArray(), hash, 0, hash.length);
    String saltString = Base64.getEncoder().encodeToString(salt);
    String hashString = Base64.getEncoder().encodeToString(hash);
    return new String[]{saltString, hashString};
  }

  /**
   * Converts a byte array to a hexadecimal string.
   *
   * @param bytes input byte array
   * @return hexadecimal string
   */
  public static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
}