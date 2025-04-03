package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1159 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] alphabet = new int[26];

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      alphabet[name.charAt(0) - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] >= 5) {
        sb.append((char) (i + 'a'));
      }
    }
    if (sb.toString().isEmpty()) {
      System.out.println("PREDAJA");
    } else {
      System.out.println(sb);
    }
  }
}

// 메모리 14056KB
// 시간 100ms
