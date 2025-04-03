package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10988 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    boolean flag = true;
    for(int i = 0; i < S.length(); i++) {
      if(S.charAt(i)!=S.charAt(S.length()-1-i)){
        flag=false;
      }
    }

    if(flag){
      System.out.println("1");
    }
    else{
      System.out.println("0");
    }
  }
}

// 메모리 14284KB
// 시간 104ms
