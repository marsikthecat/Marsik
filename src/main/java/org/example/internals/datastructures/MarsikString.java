package org.example.internals.datastructures;

public class MarsikString {

  private char[] data;
  private int size;
  public MarsikString(String string) {
    if (string == null) {
      throw new IllegalArgumentException("String cannot be null, my friend!");
    }
    this.data = string.toCharArray();
    this.size = data.length;
  }

  private MarsikString(char[] data) {
    if (data == null) {
      throw new IllegalArgumentException("Character array cannot be null, my friend!");
    }
    this.data = data.clone();
  }

  public MarsikString(MarsikString string) {
    if (string == null) {
      throw new IllegalArgumentException("String cannot be null, my friend!");
    }
    this.data = string.data.clone();
    this.size = string.size;
  }

  public void setCharAt(int index, char c) {
    if (index < 0 || index >= data.length) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index + " my friend!");
    }
    data[index] = c;
  }

  public char getCharAt(int index) {
    if (index < 0 || index >= data.length) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index + " my friend!");
    }
    return data[index];
  }

  public int length() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void print() {
    System.out.print(new String(data, 0, size));
  }

  public int indexOf(char c) {
    int index = -1;
    for (int i = 0; i < data.length; i++) {
      if (data[i] == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  public int[] allIndexOf(char c) {
    int counter = 0;
    for (char datum : data) {
      if (datum == c) {
        counter++;
      }
    }
    int[] indices = new int[counter];
    for (int i = 0, j = 0; i < data.length; i++) {
      if (data[i] == c) {
        indices[j] = i;
        j++;
      }
    }
    return indices;
  }

  public int firstIndexOf(char c) {
    int index = -1;
    for (int i = 0; i < data.length; i++) {
      if (data[i] == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  public int lastIndexOf(char c) {
    int index = -1;
    for (int i = data.length - 1; i >= 0; i--) {
      if (data[i] == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  public boolean contains(char c) {
    boolean found = false;
    for (char chr : data) {
      if (chr == c) {
        found = true;
        break;
      }
    }
    return found;
  }

  public int count(char c) {
    int found = 0;
    for (char chr : data) {
      if (chr == c) {
        found++;
      }
    }
    return found;
  }

  public void replaceAll(char oldChar, char newChar) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == oldChar) {
        data[i] = newChar;
      }
    }
  }

  public void reverse() {
    for (int i = 0; i < data.length / 2; i++) {
      char tmp = data[i];
      data[i] = data[data.length - 1 - i];
      data[data.length - 1 - i] = tmp;
    }
  }

  public void append(char c) {
    if (size == data.length) {
      char[] newData = new char[Math.max(1, data.length * 2)];
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
    data[size++] = c;
  }

  public void append(String str) {
    if (str == null) {
      throw new IllegalArgumentException("String cannot be null, my friend!");
    }
    char[] strArray = str.toCharArray();
    for (char c : strArray) {
      append(c);
    }
  }

  public MarsikString subString(int start, int end) {
    if (start < 0 || end > data.length || start > end) {
      throw new IndexOutOfBoundsException("start and end are not valid, my friend!");
    }
    char[] newData = new char[end - start];
    System.arraycopy(data, start, newData, 0, end - start);
    return new MarsikString(newData);
  }

  public String toJavaString() {
    return new String(data);
  }

  public MarsikString replacePart(int start, int end, MarsikString replacement) {
    if (start < 0 || end > data.length || start > end) {
      throw new IndexOutOfBoundsException("start and end are not valid, my friend!");
    }
    if (replacement.isEmpty() || replacement.length() != end - start) {
      throw new IllegalArgumentException("replacement-string must have same length as the " +
              "size of the part you want to replace, my friend!");
    }
    char[] newData = data;
    for (int i = start; i < end; i++) {
      newData[i] = replacement.getCharAt(i - start);
    }
    return new MarsikString(newData);
  }

  public void toUpperCase() {
    for (int i = 0; i < data.length; i++) {
      if (data[i] >= 'a' && data[i] <= 'z') {
        data[i] = (char) (data[i] - 32);
      }
    }
  }

  public void toLowerCase() {
    for (int i = 0; i < data.length; i++) {
      if (data[i] >= 'A' && data[i] <= 'Z') {
        data[i] = (char) (data[i] + 32);
      }
    }
  }

  public boolean startsWith(char[] c) {
    if (c == null || c.length > data.length) {
      throw new IllegalArgumentException("Character array is invalid");
    }
    for (int i = 0; i < c.length; i++) {
      if (data[i] != c[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean endsWith(char[] c) {
    if (c == null || c.length > data.length) {
      throw new IllegalArgumentException("Character array is invalid");
    }
    for (int i = 0; i < c.length; i++) {
      if (data[data.length - c.length + i] != c[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome() {
    for (int i = 0; i < data.length / 2; i++) {
      if (data[i] != data[data.length - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  public int[] alphabetIndex() {
    if (!hasOnlyLetters()) {
      throw new IllegalStateException("String has non-alphabetic characters, my friend!");
    }
    int[] indexes = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      char c = data[i];
      indexes[i] = Character.toUpperCase(c) - 'A';
    }
    return indexes;
  }

  public boolean hasOnlyDigits() {
    for (char c : data) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  public boolean hasDigits() {
    for (char c : data) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasOnlyLetters() {
    for (char c : data) {
      if (!Character.isLetter(c)) {
        return false;
      }
    }
    return true;
  }

  public boolean hasLetters() {
    for (char c : data) {
      if (Character.isLetter(c)) {
        return true;
      }
    }
    return false;
  }

  public boolean isAlphaNumeric() {
    for (char c : data) {
      if (!Character.isLetterOrDigit(c)) {
        return false;
      }
    }
    return true;
  }

  public void capitalize() {
    char firstChar = data[0];
    if (firstChar >= 'a' && firstChar <= 'z') {
      data[0] = (char) (firstChar - 32);
    }
    for (int i = 1; i < data.length; i++) {
      if (data[i] >= 'A' && data[i] <= 'Z') {
        data[i] = (char) (data[i] + 32);
      }
    }
  }

  public MarsikString removeWhiteSpaces(MarsikString string) {
    return new MarsikString(string.data);
  }

  public MarsikString abbreviation(MarsikString string) {
    return new MarsikString(string.data);
  }

  public int numberOfVowels(MarsikString string) {
    return 0;
  }

  public int numberOfConsonants(MarsikString string) {
    return 0;
  }
}