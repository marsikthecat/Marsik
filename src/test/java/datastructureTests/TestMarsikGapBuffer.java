package datastructureTests;

import org.example.internals.datastructures.MarsikGapBuffer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMarsikGapBuffer {

  @Test
  void insert_atBeginning() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("abc", 0);
    assertEquals("abc", dump(gb));
  }

  @Test
  void insert_atEnd() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("hello", 0);
    gb.insert(" world", 5);
    assertEquals("hello world", dump(gb));
  }

  @Test
  void insert_inMiddle() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("helo", 0);
    gb.insert("l", 3);
    assertEquals("hello", dump(gb));
  }

  @Test
  void multiple_inserts_different_positions() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("abc", 0);
    gb.insert("X", 1);
    gb.insert("Y", 3);
    assertEquals("aXbYc", dump(gb));
  }

  @Test
  void cursor_move_left_and_right() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("abcdef", 0);
    gb.insert("X", 3);
    gb.insert("Y", 1);
    assertEquals("aYbcXdef", dump(gb));
  }

  @Test
  void gap_grows_automatically() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("0123456789", 0);
    gb.insert("ABCDE", 10);
    assertEquals("0123456789ABCDE", dump(gb));
  }

  @Test
  void large_insert_single_position() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    gb.insert("abcdefghijklmnopqrstuvwxyz", 0);
    assertEquals("abcdefghijklmnopqrstuvwxyz", dump(gb));
  }

  @Test
  void repeated_small_inserts() {
    MarsikGapBuffer gb = new MarsikGapBuffer();

    for (int i = 0; i < 20; i++) {
      gb.insert(String.valueOf(i % 10), i);
    }
    assertEquals("01234567890123456789", dump(gb));
  }

  private String dump(MarsikGapBuffer gb) {
    try {
      var bufferField = MarsikGapBuffer.class.getDeclaredField("buffer");
      bufferField.setAccessible(true);
      char[] buf = (char[]) bufferField.get(gb);

      StringBuilder sb = new StringBuilder();
      for (char c : buf) {
        if (c != '\0' && c != '_') {
          sb.append(c);
        }
      }
      return sb.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}