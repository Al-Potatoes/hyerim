package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9372 {
  static List<List<Integer>> graph;
  static boolean[] visited;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      graph = new ArrayList<>();
      visited = new boolean[N + 1];

      for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph.get(u).add(v);
        graph.get(v).add(u);
      }

      int answer = bfs(1);
      bw.write(answer + "\n");
    }

    bw.flush();
    bw.close();
  }

  public static int bfs(int V) {
    Queue<Integer> q = new LinkedList<>();
    q.add(V);
    visited[V] = true;

    int cnt = 0;

    while (!q.isEmpty()) {
      int now = q.poll();
      for (int next : graph.get(now)) {
        if (!visited[next]) {
          visited[next] = true;
          q.add(next);
          cnt++;
        }
      }
    }

    return cnt;
  }
}

// 시간 428