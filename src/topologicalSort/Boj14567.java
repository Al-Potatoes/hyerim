package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj14567 {
  static int N;
  static List<List<Integer>> adj = new ArrayList<>();
  static int[] inDegree;
  static int[] cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    inDegree = new int[N+1];
    cnt = new int[N+1];

    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      adj.get(u).add(v);
      inDegree[v]++;
    }

    topologicalSort();
  }

  private static void topologicalSort() {
    PriorityQueue<Integer> q = new PriorityQueue<>();

    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
        cnt[i] = 1;
      }
    }

    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : adj.get(u)) {
        inDegree[v]--;

        cnt[v]=Math.max(cnt[v], cnt[u]+1);

        if (inDegree[v] == 0) {
          q.add(v);
        }
      }
    }

    for (int i=1;i<=N;i++) {
      System.out.print(cnt[i]+ " ");
    }

  }
}

// 시간 596ms