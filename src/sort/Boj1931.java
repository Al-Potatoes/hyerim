package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] time = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] s = br.readLine().split(" ");
      time[i][0] = Integer.parseInt(s[0]);
      time[i][1] = Integer.parseInt(s[1]);
    }
    Arrays.sort(time, Comparator.comparingInt((int[]a) -> a[1]).thenComparing(a->a[0]));
    int lastTime=0,cnt=0;

    for(int i=0;i<N;i++){
      if(time[i][0]>=lastTime){
        cnt++;
        lastTime=time[i][1];
      }
    }

    System.out.println(cnt);
  }
}
