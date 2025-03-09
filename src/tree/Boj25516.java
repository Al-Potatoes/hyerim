package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj25516 {

  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int n=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());

    List<List<Integer>> tree=new ArrayList<>(n);
    for(int i=0;i<n;i++){
      tree.add(new ArrayList<>());
    }

    for(int i=0;i<n-1;i++){
      st=new StringTokenizer(br.readLine());
      int u=Integer.parseInt(st.nextToken());
      int v=Integer.parseInt(st.nextToken());
      tree.get(u).add(v);
      tree.get(v).add(u);
    }

    int[] apples = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      apples[i] = Integer.parseInt(st.nextToken());
    }

    int[]distance=new int[n];
    boolean[] visited=new boolean[n];
    Queue<Integer> q=new LinkedList<>();

    q.add(0);
    distance[0]=0;
    visited[0]=true;

    while(!q.isEmpty()){
      int current=q.poll();
      for(int next:tree.get(current)){
        if(!visited[next]){
          visited[next]=true;
          q.add(next);
          distance[next]=distance[current]+1;
        }
      }
    }

    int result=0;
    for(int i=0;i<n;i++){
      if(distance[i]<=k&&apples[i]==1){
        result++;
      }
    }

    System.out.println(result);
  }
}

// 시간 652ms