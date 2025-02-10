package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int cnt = 1;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (num == cnt) {
        cnt++;
        while (!stack.isEmpty() && stack.peek() == cnt) {
          stack.pop();
          cnt++;
        }
      } else {
        stack.push(num);
      }
    }

    System.out.println(stack.isEmpty() ? "Nice" : "Sad");
  }
}

// 시간 112ms
