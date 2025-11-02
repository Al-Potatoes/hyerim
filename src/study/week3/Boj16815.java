package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj16815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean find = false;
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (!find && S.charAt(i) == '(') {
                stack.push('(');
            } else if (S.charAt(i) == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    cnt = find ? cnt + 1 : cnt;
                }
            } else {
                find = true;
            }
        }
        System.out.println(cnt);
    }
}

//TODO: 스택을 이용해 ()괄호 쌍이 몇 개인지 찾으시오

