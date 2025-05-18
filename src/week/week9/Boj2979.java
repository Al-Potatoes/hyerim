package week.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2979 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] fee = new int[4];
    int[][] car = new int[3][2];
    int sum = 0;
    fee[0] = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i < 4; i++) {
      fee[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      car[i][0] = Integer.parseInt(st.nextToken());
      car[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int time = 1; time <= 100; time++) {
      int cnt = 0;
      for (int i = 0; i < 3; i++) {
        if (car[i][0] <= time && car[i][1] > time) {
          cnt++;
        }
      }
      sum += fee[cnt] * cnt;
    }

    System.out.println(sum);
  }
}

// 메모리 14168KB
// 시간 100ms
