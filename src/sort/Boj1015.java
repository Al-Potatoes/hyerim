package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());
    int arr[][]=new int[N][2];
    int rank[]=new int[N];
    StringTokenizer st=new StringTokenizer(br.readLine());

    for(int i=0; i<N;i++){
      arr[i][0]=Integer.parseInt(st.nextToken());
      arr[i][1]=i;
    }

    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

    for(int i=0;i<N;i++){
      rank[arr[i][1]]=i;
    }
    for(int i=0;i<N;i++){
      System.out.print(rank[i]+" ");
    }
  }
}
