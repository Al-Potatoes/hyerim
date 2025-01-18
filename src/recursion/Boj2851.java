package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2851 {
  static int[] arr = new int[10];
  static int max = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 10; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    mario(0, arr[0]);

    System.out.println(max);
  }

  public static void mario(int i, int sum) {
    if (Math.abs(100 - sum) < Math.abs(100 - max)) {
      max = sum;
    } else if (Math.abs(100 - sum) == Math.abs(100 - max) && sum > max) {
      max = sum;
    }
    if (i == 9) {
      return;
    }
    mario(i + 1, sum + arr[i + 1]);
  }
}
