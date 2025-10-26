package stack;

import java.util.*;
import java.io.*;

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

/*
TODO:
1 2 3 4 5 6 7 8
n개의 숫자 배열 순서에 맞게 pop을 해야 함
1 2 5
4 3 6
*/
