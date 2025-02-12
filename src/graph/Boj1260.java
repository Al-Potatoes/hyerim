package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260 {
  static int N;
  static boolean[] visited;
  //static LinkedList<Integer> []graph;
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    graph = new int[N+1][N+1];
    visited = new boolean[N+1];
    for(int i=0;i<M;i++){
      st=new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v]=1;
      graph[v][u]=1;
    }
    DFS(V);
    System.out.println();
    visited=new boolean[N+1];
    BFS(V);

  }

  public static void BFS(int V){
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(V);
    visited[V] = true;

    while(!q.isEmpty()){
      int nodeIdx=q.poll();
      System.out.print(nodeIdx+" ");

      for (int i = 1; i <= N; i++) {
        if (graph[nodeIdx][i] == 1 && !visited[i]) {
          visited[i] = true;
          q.offer(i);
        }
      }
    }
  }

  public static void DFS(int V) {
    visited[V] = true;
    System.out.print(V + " ");

    for (int i = 1; i <=N; i++) {
      if (graph[V][i] == 1 && !visited[i]) {
        DFS(i);
      }
    }
  }
}

// 시간 344ms