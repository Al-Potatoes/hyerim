package week.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    StringBuilder sb = new StringBuilder();

    for(char c : S.toCharArray()) {
      if (Character.isUpperCase(c)) {
        sb.append((char) (((c - 'A') + 13) % 26 + 'A'));
      }
      else if(Character.isLowerCase(c)) {
        sb.append((char) (((c - 'a') + 13) % 26 + 'a'));
      }
      else{
        sb.append(c);
      }
    }

    System.out.println(sb);
  }
}

// 메모리 14188KB
// 시간 104ms
