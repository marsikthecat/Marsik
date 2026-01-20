package org.example.internals.datastructures.extendedArrays;

public class MarsikGapBuffer {
  private final char[] buffer = new char[50];
  private final int gap_size = 10;
  private int gap_left = 0;
  private int gap_right = gap_size - gap_left - 1;
  private int size = 10;

  public void grow(int k, int position) {
    char[] a = new char[size];
    if (size - position >= 0) {
      System.arraycopy(buffer, position, a, 0, size - position);
    }
    for (int i = 0; i < k; i++) {
      buffer[i + position] = '_';
    }
    for (int i = 0; i < k; i++) {
      buffer[position + k + i] = a[i];
    }
    size += k;
    gap_right += k;
  }

  public void left(int position) {
    while (position < gap_left) {
      gap_left--;
      gap_right--;
      buffer[gap_right + 1] = buffer[gap_left];
      buffer[gap_left] = '_';
    }
  }

  public void right(int position) {
    while (position > gap_left) {
      gap_left++;
      gap_right++;
      buffer[gap_left - 1] = buffer[gap_right];
      buffer[gap_right] = '_';
    }
  }

  public void move_cursor(int position) {
    if (position < gap_left) {
      left(position);
    } else {
      right(position);
    }
  }

  public void insert(String input, int position) {
    int len = input.length();
    int i = 0;
    if (position != gap_left) {
      move_cursor(position);
    }
    while (i < len) {
      if (gap_right == gap_left) {
        int k = 10;
        grow(k, position);
      }
      buffer[gap_left] = input.charAt(i);
      gap_left++;
      i++;
      position++;
    }
  }
}