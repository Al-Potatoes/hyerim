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
