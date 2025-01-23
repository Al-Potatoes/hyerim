package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj20437 {
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      char[] W = br.readLine().toCharArray();
      int k = Integer.parseInt(br.readLine());
      findLen(W, k);
    }
    System.out.println(sb);
  }

  static void findLen(char[] W, int k) {
    int[][] alphabet = new int[26][W.length];
    int[] cnt = new int[26];

    int min = 100001;
    int max = 0;

    for (int i = 0; i < W.length; i++) {
      char x = W[i];
      int idx = x - 'a';

      alphabet[idx][cnt[idx]] = i;
      cnt[idx]++;

      if (cnt[idx] >= k) {
        for (int j = cnt[idx] - k; j >= 0; j--) {
          int minCnt = alphabet[idx][j];
          int maxCnt = alphabet[idx][j + k - 1];

          min = Math.min(min, maxCnt - minCnt + 1);
          max = Math.max(max, maxCnt - minCnt + 1);
        }
      }
    }

    if (max == 0) {
      sb.append("-1").append("\n");
    } else {
      sb.append(min).append(" ").append(max).append("\n");
    }
  }
}
