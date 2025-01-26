package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2840 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, K, sum = 0, S = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    char[] arr = new char[N];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      S = Integer.parseInt(st.nextToken());
      char alphabet = st.nextToken().charAt(0);
      int idx = (sum + S) % N;
      if (arr[idx] == '\u0000') {
        arr[idx] = alphabet;
      } else if (arr[idx] != alphabet){
        System.out.println("!");
        return;
      }
      sum = idx;
    }

    int[] alphabet = new int[26];
    for (char c : arr) {
      if (c != '\u0000') {
        if (alphabet[c - 'A'] == 1) {
          System.out.println("!");
          return;
        }
        alphabet[c - 'A'] = 1;
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print(arr[(sum - i + N) % N] == '\u0000' ? '?' : arr[(sum - i + N) % N]);
    }
  }
}
