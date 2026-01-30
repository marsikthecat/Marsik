package org.example.internals.datastructures;

/**
 * A simple implementation of a bit set using a byte array.
 * Allows setting, clearing, and querying individual bits, as well as
 * performing logical OR and AND operations with another MarsikBitSet.
 */
public class MarsikBitSet {

  private byte[] bits;
  private final int bitSetSize;

  /**
   * Constructs a MarsikBitSet of the specified size.
   *
   * @param size the number of bits this set can hold
   */
  public MarsikBitSet(int size) {
    bitSetSize = size;
    bits = new byte[1 + size / 8];
  }

  /**
   * Clears all bits in this bit set.
   */
  public void clear() {
    bits = new byte[bits.length];
  }

  /**
   * Sets the bit at the specified index to 1.
   *
   * @param n the index of the bit to set (0-based)
   */
  public void setBit(int n) {
    bits[n / 8] |= (byte) (1 << (n % 8));
  }

  /**
   * Returns whether the bit at the specified index is set (1).
   *
   * @param n the index of the bit to check (0-based)
   * @return true if the bit is set, false otherwise
   */
  public boolean getBit(int n) {
    return ((bits[n / 8] & (1 << (n % 8))) != 0);
  }

  /**
   * Clears the bit at the specified index (sets it to 0).
   *
   * @param n the index of the bit to clear (0-based)
   */
  public void clearBit(int n) {
    bits[n / 8] &= (byte) ((1 << (n % 8)) ^ ((1 << 8) - 1));
  }

  /**
   * Performs a bitwise OR with another MarsikBitSet.
   * Sets each bit in this set to 1 if the corresponding bit in the other set is 1.
   *
   * @param set the other MarsikBitSet to OR with
   */
  public void or(MarsikBitSet set) {
    for (int i = 0; i < bits.length; i++) {
      if (i < set.bits.length) {
        bits[i] |= set.bits[i];
      } else {
        break;
      }
    }
  }

  /**
   * Performs a bitwise AND with another MarsikBitSet.
   * Sets each bit in this set to 1 only if the corresponding bit in the other set is also 1.
   *
   * @param set the other MarsikBitSet to AND with
   */
  public void and(MarsikBitSet set) {
    for (int i = 0; i < bits.length; i++) {
      if (i < set.bits.length) {
        bits[i] &= set.bits[i];
      } else {
        bits[i] = 0;
      }
    }
  }

  /**
   * Displays all set bits in this MarsikBitSet.
   * Outputs the indices of bits that are set to 1.
   */
  public void display() {
    System.out.print("\nBit Set : ");
    for (int i = 0; i < bitSetSize; i++) {
      if (getBit(i)) {
        System.out.print(i + " ");
      }
    }
    System.out.print(" ");
  }
}