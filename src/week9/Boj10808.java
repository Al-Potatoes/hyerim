package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10808 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    StringBuilder sb = new StringBuilder();
    int[] alphabet = new int[26];

    for (char c : S.toCharArray()) {
      alphabet[c - 'a']++;
    }

    for(int i=0;i<26;i++){
      sb.append(alphabet[i]);
      sb.append(" ");
    }

    System.out.println(sb);
  }
}

// 메모리 14376KB
// 시간 100ms
