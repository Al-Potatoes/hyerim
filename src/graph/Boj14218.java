package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14218 {
  static int N,M;
  static int [][]graph;
  static StringBuilder sb=new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());
    graph=new int[N+1][N+1];
    for(int i=0;i<M;i++){
      st=new StringTokenizer(br.readLine());
      int u=Integer.parseInt(st.nextToken());
      int v=Integer.parseInt(st.nextToken());
      graph[u][v]=1;
      graph[v][u]=1;
    }

    int Q=Integer.parseInt(br.readLine());
    for(int i=0;i<Q;i++){
      st=new StringTokenizer(br.readLine());
      int u=Integer.parseInt(st.nextToken());
      int v=Integer.parseInt(st.nextToken());
      graph[u][v]=1;
      graph[v][u]=1;

      BFS();
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static void BFS(){
    int[]dist=new int[N+1];
    Arrays.fill(dist,-1);
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(1);
    dist[1] = 0;

    while(!q.isEmpty()){
      int nodeIdx=q.poll();

      for (int i = 1; i <= N; i++) {
        if (graph[nodeIdx][i] == 1 && dist[i]==-1) {
          dist[i]=dist[nodeIdx]+1;
          q.offer(i);
        }
      }
    }
    for(int i=1;i<=N;i++){
      sb.append(dist[i]+" ");
    }
  }
}

// 시간 740ms