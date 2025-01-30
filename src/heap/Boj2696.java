package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2696 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int M = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      StringBuilder sb = new StringBuilder();
      int cnt = 0;

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        if (!st.hasMoreTokens()) {
          st = new StringTokenizer(br.readLine());
        }
        int num = Integer.parseInt(st.nextToken());

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
          maxHeap.offer(num);
        } else {
          minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
          minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
          maxHeap.offer(minHeap.poll());
        }

        if (j % 2 == 0) {
          sb.append(maxHeap.peek()).append(" ");
          cnt++;
          if (cnt % 10 == 0) {
            sb.append("\n");
          }
        }
      }

      result.append(cnt).append("\n").append(sb).append("\n");
    }
    System.out.print(result);
  }
}
