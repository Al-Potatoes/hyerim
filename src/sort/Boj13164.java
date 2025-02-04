package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13164 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=1;i<N;i++){
      pq.add(arr[i]-arr[i-1]);
    }
    for (int i = 0; i < K - 1; i++) {
      pq.poll();
    }

    int cost=0;
    while(!pq.isEmpty()){
      cost+=pq.poll();
    }

    System.out.println(cost);
  }
}
