package datastructureTests;

import org.example.internals.datastructures.MarsikBitSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikBitSet {

  @Test
  public void testSetAndGetBit() {
    MarsikBitSet bitSet = new MarsikBitSet(16);
    bitSet.setBit(0);
    bitSet.setBit(3);
    bitSet.setBit(15);

    assertTrue(bitSet.getBit(0));
    assertTrue(bitSet.getBit(3));
    assertTrue(bitSet.getBit(15));
    assertFalse(bitSet.getBit(1));
    assertFalse(bitSet.getBit(14));
  }

  @Test
  public void testClearBit() {
    MarsikBitSet bitSet = new MarsikBitSet(8);
    bitSet.setBit(2);
    bitSet.setBit(5);

    assertTrue(bitSet.getBit(2));
    bitSet.clearBit(2);
    assertFalse(bitSet.getBit(2));
    assertTrue(bitSet.getBit(5));
  }

  @Test
  public void testClearAll() {
    MarsikBitSet bitSet = new MarsikBitSet(10);
    for (int i = 0; i < 10; i++) bitSet.setBit(i);
    bitSet.clear();
    for (int i = 0; i < 10; i++) assertFalse(bitSet.getBit(i));
  }

  @Test
  public void testOrOperation() {
    MarsikBitSet a = new MarsikBitSet(8);
    MarsikBitSet b = new MarsikBitSet(8);
    a.setBit(1);
    a.setBit(3);
    b.setBit(3);
    b.setBit(4);
    b.display();

    a.or(b);
    b.display();
    assertTrue(a.getBit(1));
    assertTrue(a.getBit(3));
    assertTrue(a.getBit(4));
    assertFalse(a.getBit(0));
  }

  @Test
  public void testAndOperation() {
    MarsikBitSet a = new MarsikBitSet(8);
    MarsikBitSet b = new MarsikBitSet(8);
    a.setBit(1);
    a.setBit(3);
    a.setBit(4);
    b.setBit(3);
    b.setBit(4);
    b.setBit(5);

    a.and(b);
    assertFalse(a.getBit(1));
    assertTrue(a.getBit(3));
    assertTrue(a.getBit(4));
    assertFalse(a.getBit(0));
    assertFalse(a.getBit(5));
  }

  @Test
  public void testOutOfBounds() {
    MarsikBitSet bitSet = new MarsikBitSet(5);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> bitSet.setBit(10));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> bitSet.getBit(10));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> bitSet.clearBit(10));
  }
}