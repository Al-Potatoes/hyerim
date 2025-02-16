package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      Queue<int[]> queue = new LinkedList<>();
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());
        queue.add(new int[]{j, num});
        priorityQueue.add(num);
      }

      int rank = 0;
      while (!queue.isEmpty()) {
        int[] current = queue.poll();

        if (current[1] == priorityQueue.peek()) {
          rank++;
          priorityQueue.poll();

          if (current[0] == M) {
            System.out.println(rank);
            break;
          }
        } else {
          queue.add(current);
        }
      }
    }
  }
}

// 시간 124ms