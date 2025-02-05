package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17619 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    int [][]tree=new int[N][3];
    int []flag=new int[N];
    for(int i=0;i<N;i++) {
      st = new StringTokenizer(br.readLine());
      tree[i][0] = Integer.parseInt(st.nextToken());
      tree[i][1] = Integer.parseInt(st.nextToken());
      tree[i][2] = Integer.parseInt(st.nextToken());
    }

    int idx=0;
    flag[0]=idx;
    for(int i=1;i<N;i++) {
      if(tree[i-1][1]>=tree[i][0]) {
        flag[i]=flag[i-1];
      }else{
        idx++;
        flag[i]=idx;
      }
    }

    for(int i=0;i<Q;i++) {
      st=new StringTokenizer(br.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      if(flag[a-1]==flag[b-1]){
        System.out.println("1");
      }
      else{
        System.out.println("0");
      }
    }
  }
}
