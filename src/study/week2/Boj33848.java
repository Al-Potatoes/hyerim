package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj33848 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        Stack<int[]> memory = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            switch (c) {
                case '1':
                    int pushNum = Integer.parseInt(st.nextToken());
                    stack.push(pushNum);
                    memory.push(new int[]{1, pushNum});
                    break;
                case '2':
                    if (!stack.empty()) {
                        memory.push(new int[]{2, stack.pop()});
                    }
                    break;
                case '3':
                    int undoCnt = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < undoCnt; j++) {
                        int[] last = memory.pop();
                        if (last[0] == 1) {
                            if (!stack.empty()) {
                                stack.pop();
                            }
                        } else {
                            stack.push(last[1]);
                        }
                    }
                    break;
                case '4':
                    sb.append(stack.size() + "\n");
                    break;
                case '5':
                    if (!stack.empty()) {
                        sb.append(stack.peek() + "\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}

//TODO: 스택의 각 명령을 잘 처리하는 프로그램을 작성하라
// stack에 이차원 배열을 써서 과거 기록 쿼리와 값을 저장하도록 한다.
// 메모리 73096KB / 시간 556ms
