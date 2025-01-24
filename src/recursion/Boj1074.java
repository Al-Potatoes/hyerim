package recursion;

import java.util.Scanner;

public class Boj1074 {
  static int r,c,M;
  static int cnt;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N= sc.nextInt();
    M=(int)Math.pow(2,N);
    r= sc.nextInt();
    c= sc.nextInt();
    cnt=0;
    findElement(0,0,M);
    System.out.println(cnt);
  }

  public static void findElement(int x,int y,int M){
    if(M==1){
      return;
    }

    int half=M/2;

    if(r<x+half&&c<y+half){
      findElement(x,y,half);
    }
    else if(r<x+half&&c>=y+half){
      cnt+=half*half;
      findElement(x,y+half,half);
    }
    else if(r>=x+half&&c<y+half){
      cnt+=2*half*half;
      findElement(x+half,y,half);
    }
    else{
      cnt+=3*half*half;
      findElement(x+half,y+half,half);
    }
  }
}
