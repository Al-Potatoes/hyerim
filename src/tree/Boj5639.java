package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5639 {
  static int[] tree = new int[10001];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int i = 0;
    String input;
    while ((input = br.readLine()) != null && !input.isEmpty()) {
      tree[i++] = Integer.parseInt(input);
    }

    postOrder(0, i - 1);
    System.out.print(sb);
  }

  static void postOrder(int s, int e) {
    if (s > e) {
      return;
    }

    int root = tree[s];

    int mid = e + 1;
    for (int i = s + 1; i <= e; i++) {
      if (tree[i] >= root) {
        mid = i;
        break;
      }
    }

    postOrder(s + 1, mid - 1);
    postOrder(mid, e);
    sb.append(root).append("\n");
  }
}

// ArrayList      30608KB	652ms
// 배열            29440KB	452ms
// StringBuilder  19896KB	240ms
