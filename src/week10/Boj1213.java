package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1213 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] X = br.readLine().toCharArray();
    StringBuilder Y = new StringBuilder();
    StringBuilder result = new StringBuilder();
    int[] alpabet = new int[26];
    int oddCnt = 0;
    int oddIdx = 0;

    for (int i = 0; i < X.length; i++) {
      alpabet[X[i] - 'A']++;
    }

    for (int i = 0; i < 26; i++) {
      if (alpabet[i] > 0 && alpabet[i] % 2 == 0) {
        for (int j = 0; j < alpabet[i] / 2; j++) {
          Y.append((char) (i + 'A'));
        }
      } else if (alpabet[i] > 0 && alpabet[i] % 2 != 0) {
        if(alpabet[i] / 2 > 0) {
          for(int j = 0; j < alpabet[i] / 2; j++) {
            Y.append((char) (i + 'A'));
          }
        }
        oddCnt++;
        oddIdx = i;
      }
    }

    result.append(Y);
    if (oddCnt == 1) {
      result.append((char) (oddIdx + 'A'));
    }
    result.append(Y.reverse());

    if (oddCnt > 1) {
      System.out.println("I'm Sorry Hansoo");
    } else {
      System.out.println(result);
    }

  }
}

// 메모리 14264KB
// 시간 104ms
