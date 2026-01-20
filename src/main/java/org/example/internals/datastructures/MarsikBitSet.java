package org.example.internals.datastructures;

public class MarsikBitSet {

  private byte[] bits;
  private final int bitSetSize;

  public MarsikBitSet(int size) {
    bitSetSize = size;
    bits = new byte[1 + size/8];
  }

  public void clear() {
    bits = new byte[bits.length];
  }

  public void setBit(int n) {
    bits[n / 8] |= (byte) (1 << (n % 8));
  }

  public boolean getBit(int n) {
    return ((bits[n / 8] & (1 << (n % 8))) != 0);
  }

  public void clearBit(int n) {
    bits[n / 8] &= (byte) ((1 << (n % 8)) ^ ((1 << 8) - 1));
  }

  public void or(MarsikBitSet set) {
    for (int i = 0; i < bits.length; i++) {
      if (i < set.bits.length) {
        bits[i] |= set.bits[i];
      } else {
        break;
      }
    }
  }

  public void and(MarsikBitSet set) {
    for (int i = 0; i < bits.length; i++) {
      if (i < set.bits.length) {
        bits[i] &= set.bits[i];
      } else {
        bits[i] = 0;
      }
    }
  }

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