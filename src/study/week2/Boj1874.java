package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0, popNum=1;
        for (int i = 1; i <= n; i++) {
            while (popNum<=n&&(stack.empty()||stack.peek() < arr[idx])) {
                stack.push(popNum++);
                sb.append("+\n");
            }

            if (stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}
