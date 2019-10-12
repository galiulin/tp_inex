package solution.task03;

import java.util.HashSet;
import java.util.Set;

public class Task03 {

  public static void main(String[] args) {
    int[] arr = {
        1,2,50,100
    };
    sum(arr);
  }
  
  public static Set<Integer> sum(int[] arr) {
    Set<Integer> sums = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        sums.add(arr[i] + arr[j]);
      }
    }
    sums.stream().forEach(System.out::println);
    return sums;
  }
}
