package week.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] x = new int[N];
    int count = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      x[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (x[i] + x[j] == M) {
          count++;
        }
      }
    }

    System.out.println(count);
  }
}

// 메모리 17816KB
// 시간 360ms
