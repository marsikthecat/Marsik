package org.example.internals.datastructures.extendedarrays;

/**
 * A simple implementation of a gap buffer for efficient text editing.
 * A gap buffer maintains a "gap" in an underlying array, allowing insertions
 * and deletions near the gap in O(1) time, while moving the cursor involves
 * shifting characters to adjust the gap position.
 * This implementation uses a fixed-size array of 50 characters and an initial
 * gap of 10 characters.
 */
public class MarsikGapBuffer {
  private final char[] buffer = new char[50];
  private final int gapSize = 10;
  private int gapLeft = 0;
  private int gapRight = gapSize - gapLeft - 1;
  private int size = 10;

  /**
   * Grows the gap by {@code k} characters starting at the given {@code position}.
   * Moves existing characters after the position to the right to make room
   * for new elements. The gap size and right boundary are updated accordingly.
   *
   * @param k        the number of characters to grow the gap by
   * @param position the position at which to grow the gap
   */
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
    gapRight += k;
  }

  /**
   * Moves the gap to the left until its left boundary reaches the given {@code position}.
   * This involves shifting characters from left of the gap to the right side.
   *
   * @param position the target cursor position to move the gap to
   */
  public void left(int position) {
    while (position < gapLeft) {
      gapLeft--;
      gapRight--;
      buffer[gapRight + 1] = buffer[gapLeft];
      buffer[gapLeft] = '_';
    }
  }

  /**
   * Moves the gap to the right until its left boundary reaches the given {@code position}.
   * This involves shifting characters from right of the gap to the left side.
   *
   * @param position the target cursor position to move the gap to
   */
  public void right(int position) {
    while (position > gapLeft) {
      gapLeft++;
      gapRight++;
      buffer[gapLeft - 1] = buffer[gapRight];
      buffer[gapRight] = '_';
    }
  }

  /**
   * Moves the cursor to the specified {@code position} by adjusting the gap.
   * Calls {@link #left(int)} or {@link #right(int)} depending on the current
   * position of the gap.
   *
   * @param position the target cursor position
   */
  public void moveCursor(int position) {
    if (position < gapLeft) {
      left(position);
    } else {
      right(position);
    }
  }

  /**
   * Inserts a string at the specified {@code position}.
   * Moves the gap to the target position if necessary. If the gap is too
   * small to fit the new text, it is grown automatically. Characters from
   * the input string are inserted one by one.
   *
   * @param input    the string to insert
   * @param position the position at which to insert the string
   */
  public void insert(String input, int position) {
    int len = input.length();
    int i = 0;
    if (position != gapLeft) {
      moveCursor(position);
    }
    while (i < len) {
      if (gapRight == gapLeft) {
        int k = 10;
        grow(k, position);
      }
      buffer[gapLeft] = input.charAt(i);
      gapLeft++;
      i++;
      position++;
    }
  }
}