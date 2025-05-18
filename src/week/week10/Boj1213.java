package week.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1213 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();
    int[] counts = new int[26];

    for (char c : input) {
      counts[c - 'A']++;
    }

    int oddCount = 0;
    int oddIndex = -1;
    StringBuilder half = new StringBuilder();

    for (int i = 0; i < 26; i++) {
      if (counts[i] % 2 != 0) {
        oddCount++;
        oddIndex = i;
      }
      for (int j = 0; j < counts[i] / 2; j++) {
        half.append((char) (i + 'A'));
      }
    }

    if (oddCount > 1) {
      System.out.println("I'm Sorry Hansoo");
      return;
    }

    StringBuilder result = new StringBuilder();
    result.append(half);
    if (oddCount == 1) {
      result.append((char) (oddIndex + 'A'));
    }
    result.append(half.reverse());

    System.out.println(result);
  }
}

// 메모리 14208KB
// 시간 108ms
