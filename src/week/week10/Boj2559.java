package week.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] X = new int[N];
    int max = Integer.MIN_VALUE;
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      X[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N - K + 1; i++) {
      int sum = 0;
      for (int j = i; j < i + K; j++) {
        sum += X[j];
      }
      if (sum > max) {
        max = sum;
      }
    }
    System.out.println(max);
  }
}

// 메모리 23996KB
// 시간 996ms
