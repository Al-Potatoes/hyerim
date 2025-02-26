package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1655 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    StringBuilder sb=new StringBuilder();

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

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

      sb.append(maxHeap.peek()).append("\n");
    }

    System.out.print(sb);
  }
}