package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11725 {
  static List<List<Integer>> tree;
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());

    tree=new ArrayList<>();
    for(int i=0;i<=N;i++){
      tree.add(new ArrayList<>());
    }

    for(int i=0;i<N-1;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    parent = new int[N+1];
    dfs(1,-1);

    for(int i=2;i<=N;i++){
      System.out.println(parent[i]);
    }

  }

  static void dfs(int idx,int par){
    parent[idx]=par;

    for(int next:tree.get(idx)){
      if (next != par) {
        dfs(next,idx);
      }
    }

  }
}

// 1200ms


/*
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nxt : adj.get(curr)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    parent[nxt] = curr;
                    q.offer(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
    }
}

시간 596ms
재귀(dfs) 안쓰고 sb 쓰니까 더 빠름
 */