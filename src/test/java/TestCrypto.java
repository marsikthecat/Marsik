import org.example.internals.crypto.Crypto;
import org.example.internals.crypto.CryptoData;
import org.example.internals.crypto.CryptoMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestCrypto {

  /**
   * Tests the encryption and decryption functionality of the Crypto class.
   * <p>
   * This test verifies that a string can be encrypted and then decrypted back
   * to its original value using the default Crypto mode.
   * <p>
   * Steps:
   * 1. Generate a cryptographic key using `Crypto.generateKey()`.
   * 2. Encrypt the test string using the generated key with `Crypto.encrypt()`.
   * 3. Decrypt the encrypted data using `Crypto.decrypt()`.
   * 4. Assert that the decrypted string matches the original test string.
   */
  @Test
  public void testCrypto() {
    String testString = "Hello World!";
    CryptoData cryptoData = Crypto.generateKey();
    CryptoData encrypted = Crypto.encrypt(testString, cryptoData);
    String decrypted = Crypto.decrypt(encrypted);
    Assertions.assertEquals(testString, decrypted);
  }
  /**
   * Tests the encryption and decryption functionality of the Crypto class in HARDCORE mode.
   * <p>
   * This test verifies that a string can be encrypted and then decrypted back
   * to its original value using the HARDCORE Crypto mode.
   * <p>
   * Steps:
   * 1. Set the Crypto mode to HARDCORE using `Crypto.setMode(CryptoMode.HARDCORE)`.
   * 2. Generate a cryptographic key using `Crypto.generateKey()`.
   * 3. Encrypt the test string using the generated key with `Crypto.encrypt()`.
   * 4. Decrypt the encrypted data using `Crypto.decrypt()`.
   * 5. Assert that the decrypted string matches the original test string.
   */
  @Test
  public void testCryptoHardMode() {
    Crypto.setMode(CryptoMode.HARDCORE);
    String testString = "Hello World!";
    CryptoData cryptoData = Crypto.generateKey();
    CryptoData encrypted = Crypto.encrypt(testString, cryptoData);
    String decrypted = Crypto.decrypt(encrypted);
    Assertions.assertEquals(testString, decrypted);
  }

  /**
   * Tests the encryption and decryption functionality of the Crypto class in EXTREME mode.
   * <p>
   * This test ensures that a string can be encrypted and then decrypted back
   * to its original value using the EXTREME Crypto mode.
   * <p>
   * Steps:
   * 1. Set the Crypto mode to EXTREME using `Crypto.setMode(CryptoMode.EXTREME)`.
   * 2. Generate a cryptographic key using `Crypto.generateKey()`.
   * 3. Encrypt the test string using the generated key with `Crypto.encrypt()`.
   * 4. Decrypt the encrypted data using `Crypto.decrypt()`.
   * 5. Assert that the decrypted string matches the original test string.
   * NOTE: This test failed to execute due to apocalyptic consumption of resources.
   * Don't try this at home, your JVM will be mad.
   */
  @Test
  @Disabled("Disabled due to apocalyptic resource consumption")
  public void testCryptoExtremeMode() {
    Crypto.setMode(CryptoMode.EXTREME);
    String testString = "Hello World!";
    CryptoData cryptoData = Crypto.generateKey();
    CryptoData encrypted = Crypto.encrypt(testString, cryptoData);
    String decrypted = Crypto.decrypt(encrypted);
    Assertions.assertEquals(testString, decrypted);
  }
}
