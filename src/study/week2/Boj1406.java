package study.week2;

import java.io.*;
import java.util.*;

public class Boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            char cmd = line.charAt(0);

            if (cmd == 'L') {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (cmd == 'D') {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (cmd == 'B') {
                if (!left.isEmpty()) left.pop();
            } else { // 'P x'
                left.push(line.charAt(2));
            }
        }

        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);
    }
}


//TODO: 스택을 두 개 만들고 커서를 움직였을 경우 다른 스택에 옮겨뒀다가 다시 pop하기
// 메모리 73232KB 시간 448ms
