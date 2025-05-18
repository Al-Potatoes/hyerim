package week.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2309 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] height = new int[9];
    int sum = 0;
    int[] remember = new int[2];

    for (int i = 0; i < 9; i++) {
      height[i] = Integer.parseInt(br.readLine());
      sum += height[i];
    }
    int remainder = sum - 100;
    for (int i = 0; i < 9; i++) {
      sum = height[i];
      for (int j = 0; j < 9; j++) {
        if (i != j) {
          int num = sum + height[j];
          if (num == remainder) {
            remember[0] = height[i];
            remember[1] = height[j];
          }
        }
      }
    }

    Arrays.sort(height);
    for (int i = 0; i < 9; i++) {
      if (remember[0] != height[i] && remember[1] != height[i]) {
        System.out.println(height[i]);
      }
    }

  }
}

// 메모리 14312KB
// 시간 104ms
