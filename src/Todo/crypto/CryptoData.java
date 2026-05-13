package org.example.internals.crypto;

import java.util.Arrays;
import javax.crypto.SecretKey;

/**
 * Container class for holding cryptographic data used by the {@link Crypto} class.
 * Supports NORMAL, HARDCORE, and EXTREME/Apocalyptic modes.
 * Contains encryption payloads, keys, salts, IVs, and MACs as appropriate per mode.
 * Provides safe getters (clones arrays) and destroy methods to clear sensitive data from memory.
 */
public class CryptoData {

  // Used by Every Mode
  private byte[] iv;
  private byte[] encrypted;

  // Normal Mode
  private SecretKey secretKey;
  private byte[] salt;

  // HardCore Mode
  private byte[] argonKey;
  private byte[] hmacKey;

  // Apocalyptic
  private byte[] kmac;

  /**
   * Not for instantiation or you will get punished.
   */
  CryptoData() {}

  /**
   * Sets the AES SecretKey for NORMAL mode.
   *
   * @param secretKey must not be null
   * @return this CryptoData instance for chaining
   * @throws IllegalArgumentException if secretKey is null
   */
  public CryptoData setSecretKey(SecretKey secretKey) {
    if (secretKey == null) {
      throw new IllegalArgumentException("SecretKey cannot be null");
    }
    this.secretKey = secretKey;
    return this;
  }

  /**
   * Sets the initialization vector (IV).
   *
   * @param iv must not be null
   * @return this CryptoData instance for chaining
   * @throws IllegalArgumentException if iv is null
   */
  public CryptoData setIv(byte[] iv) {
    if (iv == null) {
      throw new IllegalArgumentException("IV cannot be null");
    }
    this.iv = iv.clone();
    return this;
  }

  /**
   * Sets the salt for key derivation (NORMAL/HARDCORE/EXTREME modes).
   *
   * @param salt must not be null
   * @return this CryptoData instance for chaining
   * @throws IllegalArgumentException if salt is null
   */
  public CryptoData setSalt(byte[] salt) {
    if (salt == null) {
      throw new IllegalArgumentException("Salt cannot be null, go to the kitchen to find it!");
    }
    this.salt = salt.clone();
    return this;
  }

  /**
   * Sets the encrypted payload.
   *
   * @param encrypted must not be null
   * @return this CryptoData instance for chaining
   * @throws IllegalArgumentException if encrypted is null
   */
  public CryptoData setEncrypted(byte[] encrypted) {
    if (encrypted == null) {
      throw new IllegalArgumentException("Encrypted cannot be null");
    }
    this.encrypted = encrypted.clone();
    return this;
  }

  /**
   * Sets the Argon2-derived key for HARDCORE or EXTREME modes.
   *
   * @param argonKey the Argon2 key bytes
   * @return this instance for chaining
   */
  public CryptoData setArgonKey(byte[] argonKey) {
    this.argonKey = argonKey.clone();
    return this;
  }

  /**
   * Sets the HMAC key for HARDCORE mode.
   *
   * @param hmacKey the HMAC key bytes
   * @return this instance for chaining
   */
  public CryptoData setHmac(byte[] hmacKey) {
    this.hmacKey = hmacKey.clone();
    return this;
  }

  /**
   * Sets the KMAC output for EXTREME mode.
   *
   * @param kmac the KMAC bytes
   * @return this instance for chaining
   */
  public CryptoData setKmac(byte[] kmac) {
    this.kmac = kmac.clone();
    return this;
  }

  /**
   * Returns a clone of the KMAC value (EXTREME mode).
   */
  public byte[] getKmac() {
    return kmac.clone();
  }

  /**
   * Returns a clone of the HMAC key (HARDCORE mode).
   */
  public byte[] getHmac() {
    return hmacKey.clone();
  }

  /**
   * Returns a clone of the Argon2 key (HARDCORE/EXTREME modes).
   */
  public byte[] getArgonKey() {
    return argonKey.clone();
  }

  /**
   * Returns the AES SecretKey (NORMAL mode).
   */
  public SecretKey getSecretKey() {
    return secretKey;
  }

  /**
   * Returns a clone of the salt.
   */
  public byte[] getSalt() {
    return salt.clone();
  }

  /**
   * Returns a clone of the initialization vector (IV).
   */
  public byte[] getIv() {
    return iv.clone();
  }

  /**
   * Returns a clone of the encrypted payload.
   */
  public byte[] getEncrypted() {
    return encrypted.clone();
  }

  /**
   * Destroys the AES SecretKey by zeroing out its encoded bytes.
   */
  public void destroyKey() {
    try {
      byte[] encoded = secretKey.getEncoded();
      if (encoded != null) {
        Arrays.fill(encoded, (byte) 0);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    secretKey = null;
  }

  /**
   * Destroys the Argon2 key by zeroing out its byte array.
   */
  public void destroyArgonKey() {
    try {
      if (argonKey != null) {
        Arrays.fill(argonKey, (byte) 0);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    argonKey = null;
  }
}