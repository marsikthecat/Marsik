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
    this.size = data.length;
  }

  public MarsikString(MarsikString string) {
    if (string == null) {
      throw new IllegalArgumentException("String cannot be null, my friend!");
    }
    this.data = string.data.clone();
    this.size = string.size;
  }

  public void setCharAt(int index, char c) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index + " my friend!");
    }
    data[index] = c;
  }

  public char getCharAt(int index) {
    if (index < 0 || index >= size) {
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
    for (int i = 0; i < size; i++) {
      if (data[i] == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  public MarsikArray<Integer> allIndexOf(char c) {
    MarsikArray<Integer> indexes = new MarsikArray<>(count(c));
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (data[i] == c) {
        indexes.set(j, i);
        j++;
      }
    }
    return indexes;
  }

  public int firstIndexOf(char c) {
    int index = -1;
    for (int i = 0; i < size; i++) {
      if (data[i] == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  public int lastIndexOf(char c) {
    int index = -1;
    for (int i = size - 1; i >= 0; i--) {
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
    for (int i = 0; i < size; i++) {
      if (data[i] == oldChar) {
        data[i] = newChar;
      }
    }
  }

  public void reverse() {
    for (int i = 0; i < size / 2; i++) {
      char tmp = data[i];
      data[i] = data[size - 1 - i];
      data[size - 1 - i] = tmp;
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
    for (int i = 0; i < str.length(); i++) {
      if (size == data.length) {
        char[] newData = new char[Math.max(1, data.length * 2)];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
      }
      data[size++] = str.charAt(i);
    }
  }

  public MarsikString subString(int start, int end) {
    if (start < 0 || end > size || start > end) {
      throw new IndexOutOfBoundsException("start and end are not valid, my friend!");
    }
    char[] newData = new char[end - start];
    System.arraycopy(data, start, newData, 0, end - start);
    return new MarsikString(newData);
  }

  public String toJavaString() {
    return new String(data, 0, size);
  }

  public void replacePart(int start, int end, MarsikString replacement) {
    if (start < 0 || end > size || start > end) {
      throw new IndexOutOfBoundsException("start and end are not valid, my friend!");
    }
    if (replacement.isEmpty() || replacement.length() != end - start) {
      throw new IllegalArgumentException("replacement-string must have same length as the " +
              "size of the part you want to replace, my friend!");
    }
    for (int i = start; i < end; i++) {
      data[i] = replacement.getCharAt(i - start);
    }
  }

  public void toUpperCase() {
    for (int i = 0; i < size; i++) {
      if (data[i] >= 'a' && data[i] <= 'z') {
        data[i] = (char) (data[i] - 32);
      }
    }
  }

  public void toLowerCase() {
    for (int i = 0; i < size; i++) {
      if (data[i] >= 'A' && data[i] <= 'Z') {
        data[i] = (char) (data[i] + 32);
      }
    }
  }

  public boolean startsWith(char[] c) {
    if (c == null || c.length > size) {
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
    if (c == null || c.length > size) {
      throw new IllegalArgumentException("Character array is invalid");
    }
    for (int i = 0; i < c.length; i++) {
      if (data[size - c.length + i] != c[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome() {
    for (int i = 0; i < size / 2; i++) {
      if (data[i] != data[size - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  public MarsikArray<Integer> alphabetIndexes() {
    if (!hasOnlyLetters()) {
      throw new IllegalStateException("String has non-alphabetic characters, my friend!");
    }
    MarsikArray<Integer> alphabetIndexes = new MarsikArray<>(size);
    for (int i = 0; i < size; i++) {
      alphabetIndexes.set(i, Character.toUpperCase(data[i]) - 'A');
    }
    return alphabetIndexes;
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
    if (size == 0) return;
    char firstChar = data[0];
    if (firstChar >= 'a' && firstChar <= 'z') {
      data[0] = (char) (firstChar - 32);
    }
    for (int i = 1; i < size; i++) {
      if (data[i] >= 'A' && data[i] <= 'Z') {
        data[i] = (char) (data[i] + 32);
      }
    }
  }

  public boolean isOnlyLowercase() {
    for (char c : data) {
      if (Character.isUpperCase(c)) {
        return false;
      }
    }
    return true;
  }

  public boolean isOnlyUppercase() {
    for (char c : data) {
      if (Character.isLowerCase(c)) {
        return false;
      }
    }
    return true;
  }

  public boolean isOnlyWhiteSpace() {
    for (char c : data) {
      if (!Character.isWhitespace(c)) {
        return false;
      }
    }
    return true;
  }

  public int toInteger() {
    if (hasOnlyDigits()) {
      return Integer.parseInt(this.toJavaString());
    }
    return -1;
  }

  public int hashCode() {
    return toJavaString().hashCode();
  }

  public boolean equals(MarsikString other) {
    return toJavaString().equals(other.toJavaString());
  }

  public void withoutWhiteSpaces() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      if (!Character.isWhitespace(data[i])) {
        sb.append(data[i]);
      }
    }
    this.data = sb.toString().toCharArray();
  }

  public int numberOfWhiteSpaces() {
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (Character.isWhitespace(data[i])) {
        count++;
      }
    }
    return count;
  }

  public int numberOfVowels() {
    int count = 0;
    for (char c : data) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        count++;
      }
    }
    return count;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public int numberOfConsonants() {
    int count = 0;
    for (char c : data) {
      if (!isVowel(c) && Character.isLetter(c)) {
        count++;
      }
    }
    return count;
  }
}