package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2014 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[K];
    PriorityQueue<Long> pq = new PriorityQueue<>();
    HashSet<Long> set = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      pq.offer((long) arr[i]);
      set.add((long) arr[i]);
    }

    long answer = 0;
    for (int cnt = 0; cnt < N; cnt++) {
      answer = pq.poll();
      for (int i = 0; i < K; i++) {
        long next = answer * arr[i];
        if (!set.contains(next)) {
          pq.offer(next);
          set.add(next);
        }
        if (answer % arr[i] == 0) break;
      }
    }
    System.out.println(answer);
  }
}
