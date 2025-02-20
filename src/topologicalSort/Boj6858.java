package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Boj6858 {

  static List<List<Integer>> adj = new ArrayList<>();
  static int[] inDegree = new int[8];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 8; i++) {
      adj.add(new ArrayList<>());
    }

    int[][] base = {{1, 7}, {1, 4}, {2, 1}, {3, 4}, {3, 5}};
    for (int[] x : base) {
      int u = x[0];
      int v = x[1];
      adj.get(u).add(v);
      inDegree[v]++;
    }

    while (true) {
      int u = Integer.parseInt(br.readLine());
      int v = Integer.parseInt(br.readLine());
      if (u == 0 && v == 0) {
        break;
      }
      adj.get(u).add(v);
      inDegree[v]++;
    }
    topologicalSort();
  }

  private static void topologicalSort() {
    PriorityQueue<Integer> q = new PriorityQueue<>();;
    Queue<Integer> result = new LinkedList<Integer>();

    for (int i = 1; i <= 7; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    int cnt = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      result.add(u);
      cnt++;
      for (int v : adj.get(u)) {
        inDegree[v]--;
        if (inDegree[v] == 0) {
          q.add(v);
        }
      }
    }

    if (cnt < 7) {
      System.out.println("Cannot complete these tasks. Going to bed.");
    } else {
      for (int num : result) {
        System.out.print(num + " ");
      }
    }
  }
}

// 시간 120ms