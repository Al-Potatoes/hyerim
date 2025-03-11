package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9934 {
  static int K,N;
  static int[] visited;
  static List<List<Integer>> tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K=Integer.parseInt(br.readLine());
    N=(int)Math.pow(2,K)-1;

    visited=new int[N];
    StringTokenizer st=new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      visited[i]=Integer.parseInt(st.nextToken());
    }

    tree=new ArrayList<>();
    for(int i=0;i<K;i++){
      tree.add(new ArrayList<>());
    }

    buildTree(0,N-1,0);

    StringBuilder sb=new StringBuilder();
    for(List<Integer> lever:tree){
      for(int i=0;i<lever.size();i++){
        sb.append(lever.get(i)+" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void buildTree(int start,int end,int depth){
    if(depth>=K||start>end) return;

    int mid=(start+end)/2;
    tree.get(depth).add(visited[mid]);

    //왼쪽 서브트리
    buildTree(start,mid-1,depth+1);
    //오른쪽 서브트리
    buildTree(mid+1,end,depth+1);
  }
}
// 시간 120ms


