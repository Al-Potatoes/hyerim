package recursion;

import java.io.*;
import java.util.*;

public class Boj1780 {
  static int N;
  static int[][] arr;
  static int[] cnt = new int[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    paper(0, 0, N);
    for (int i = 0; i < 3; i++) {
      System.out.println(cnt[i]);
    }
  }

  public static void paper(int x, int y, int size) {
    int num = arr[x][y];
    int flag = 1;

    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (arr[i][j] != num) {
          flag = 0;
          break;
        }
      }
    }

    if (flag == 1) {
      if (num == -1) cnt[0]++;
      else if (num == 0) cnt[1]++;
      else if (num == 1) cnt[2]++;
    } else {
      int newSize = size / 3;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          paper(x + i * newSize, y + j * newSize, newSize);
        }
      }
    }
  }
}
