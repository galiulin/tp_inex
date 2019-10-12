package solution.task03;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class Task03Test {

  @Test
  public void sumTest() {
    int[] expected = {
        3,
        51,
        52,
        101,
        102,
        150
    };
    int[] ints = {
        1,
        2,
        50,
        100
    };

    Set<Integer> sum = Task03.sum(ints);
    int[] actual = sum.stream().mapToInt(Integer::intValue).sorted().toArray();
    assertArrayEquals(expected, actual);

  }
}