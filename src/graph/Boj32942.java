package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj32942 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    StringBuilder sb=new StringBuilder();
    for(int i=1;i<=10;i++){
      int flag=0;
      for(int j=1;j<=10;j++){
        if(A*i+B*j==C){
          flag=1;
          sb.append(j);
          sb.append(" ");
        }
      }
      if(flag==0){
        sb.append("0\n");
      }else{
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}

// 시간 104ms