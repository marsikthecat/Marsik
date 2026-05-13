import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileHandler {

  @Test
  void createsNewFileSuccessfully() {
    String filePath = "testFile.txt";
    boolean result = FileHandler.createNewFile(filePath);
    assertTrue(result);
    assertTrue(FileHandler.doesFileExist(filePath));
    FileHandler.deleteFile(filePath);
  }

  @Test
  void doesNotCreateFileIfAlreadyExists() {
    String filePath = "existingFile.txt";
    FileHandler.createNewFile(filePath);
    boolean result = FileHandler.createNewFile(filePath);
    assertFalse(result);
    FileHandler.deleteFile(filePath);
  }

  @Test
  void writesContentToFileSuccessfully() {
    String filePath = "writeTestFile.txt";
    String content = "Hello, World!";
    FileHandler.createNewFile(filePath);
    boolean result = FileHandler.writeToFile(filePath, content);
    assertTrue(result);
    assertEquals(content, FileHandler.readFile(filePath).trim());
    FileHandler.deleteFile(filePath);
  }

  @Test
  void doesNotWriteToFileIfPathIsInvalid() {
    String filePath = "invalidPath/invalidFile.txt";
    String content = "This will fail";
    boolean result = FileHandler.writeToFile(filePath, content);
    assertFalse(result);
  }

  @Test
  void readsFileContentSuccessfully() {
    String filePath = "readTestFile.txt";
    String content = "File content to read.";
    FileHandler.createNewFile(filePath);
    FileHandler.writeToFile(filePath, content);
    String result = FileHandler.readFile(filePath).trim();
    assertEquals(content, result);
    FileHandler.deleteFile(filePath);
  }

  @Test
  void returnsEmptyStringWhenFileNotFound() {
    String filePath = "nonExistentFile.txt";
    String result = FileHandler.readFile(filePath);
    assertEquals("", result);
  }

  @Test
  void deletesFileSuccessfully() {
    String filePath = "deleteTestFile.txt";
    FileHandler.createNewFile(filePath);
    boolean result = FileHandler.deleteFile(filePath);
    assertTrue(result);
    assertFalse(FileHandler.doesFileExist(filePath));
  }

  @Test
  void doesNotDeleteNonExistentFile() {
    String filePath = "nonExistentFile.txt";
    boolean result = FileHandler.deleteFile(filePath);
    assertFalse(result);
  }

  @Test
  void checksFileExistenceCorrectly() {
    String filePath = "existenceTestFile.txt";
    FileHandler.createNewFile(filePath);
    assertTrue(FileHandler.doesFileExist(filePath));
    FileHandler.deleteFile(filePath);
    assertFalse(FileHandler.doesFileExist(filePath));
  }

}
