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
    int size=4*N-3;
    arr=new char[size][size];

    star(0,0,size);

    print(size);
  }

  private static void print(int size) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        sb.append(arr[i][j] != 0 ? arr[i][j] : " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static void star(int x,int y,int size){
    if (size == 1) {
      arr[x][y] = '*';
      return;
    }
    for(int i=0;i<size;i++){
      arr[x][y+i]='*';
      arr[x+i][y]='*';
      arr[x+size-1][y+i]='*';
      arr[x+i][y+size-1]='*';
    }
    star(x+2,y+2,size-4);
  }
}
