package array;

import java.util.Scanner;

public class Boj2563 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int[][] arr = new int[n][2];
    int[][] ans = new int[100][100];
    int cnt=0;

    for(int i=0;i<n;i++){
      arr[i][0]=sc.nextInt();
      arr[i][1]=sc.nextInt();
    }
    for(int i=0;i<n;i++){
      for(int j=arr[i][0];j<100&&j<arr[i][0]+10;j++){
        for(int k=arr[i][1];k<100&&k<arr[i][1]+10;k++){
          ans[j][k]=1;
        }
      }
    }

    for(int i=0;i<100;i++){
      for(int j=0;j<100;j++){
        if(ans[i][j]==1){
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
