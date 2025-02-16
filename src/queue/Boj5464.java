package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5464 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] rates = new int[N + 1];
    int[] weights = new int[M + 1];
    int[] parkingCar = new int[M + 1];

    PriorityQueue<Integer> emptySpace = new PriorityQueue<>();
    Queue<Integer> waiting = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      rates[i] = Integer.parseInt(br.readLine());
      emptySpace.add(i);
    }

    for (int i = 1; i <= M; i++) {
      weights[i] = Integer.parseInt(br.readLine());
    }

    int sum = 0;

    for (int i = 0; i < 2 * M; i++) {
      int car = Integer.parseInt(br.readLine());

      if (car > 0) {
        if (!emptySpace.isEmpty()) {
          int idx = emptySpace.poll();
          parkingCar[car] = idx;
        } else {
          waiting.add(car);
        }
      } else {
        car = -car;
        int idx = parkingCar[car];
        sum += weights[car] * rates[idx];

        if (!waiting.isEmpty()) {
          parkingCar[waiting.poll()] = idx;
        } else {
          emptySpace.add(idx);
        }
      }
    }

    System.out.println(sum);
  }
}

// 120ms