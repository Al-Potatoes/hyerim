package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
  static int[][] graph;
  static boolean[] visited;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    int M=Integer.parseInt(br.readLine());
    graph = new int[N+1][N+1];
    visited = new boolean[N+1];
    for(int i=0;i<M;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v]=1;
      graph[v][u]=1;
    }
    System.out.println(BFS(1)-1);
  }

  public static int BFS(int V){
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(V);
    visited[V] = true;
    int cnt=0;
    while(!q.isEmpty()){
      int nodeIdx=q.poll();
      cnt++;

      for (int i = 1; i <= N; i++) {
        if (graph[nodeIdx][i] == 1 && !visited[i]) {
          visited[i] = true;
          q.offer(i);
        }
      }
    }
    return cnt;
  }
}

// 시간 104ms
