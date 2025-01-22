package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10994 {
  static int N;
  static char arr[][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    arr=new char[4*N-3][4*N-3];

    star(0,0,N);
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<4*N-3;i++){
      for(int j=0;j<4*N-3;j++){
        sb.append(arr[i][j] != 0 ? arr[i][j] : ' ');
      }
      sb.append("\n");
    }
    for(int i=0;i<4*N-3;i++){
      for(int j=0;j<4*N-3;j++){
        System.out.print(arr[i][j] != 0 ? arr[i][j] : ' ');
      }
      System.out.print("\n");
    }
  }

  public static void star(int x,int y,int size){
    if (size == 1) {
      arr[x][y] = '*';
      return;
    }
    for(int i=x;i<x+(4*size-3);i++){
      for(int j=y;j<y+(4*size-3);j++){
        if(i==x||i==x+(4*size-3)-1){
          arr[i][j] = '*';
        }
        if(j==y||j==y+(4*size-3)-1){
          arr[i][j] = '*';
        }
      }
    }
    star(x+2,y+2,size-1);
  }
}
