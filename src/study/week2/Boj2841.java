package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Stack<Integer>[] lineStacks = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            lineStacks[i] = new Stack<>();
        }
        int moveCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int lineNum = Integer.parseInt(st.nextToken());
            int fretNum = Integer.parseInt(st.nextToken());

            Stack<Integer> current = lineStacks[lineNum];
            while (!current.empty() && fretNum < current.peek()) {
                moveCnt++;
                current.pop();
            }

            if (current.empty() || current.peek() < fretNum) {
                moveCnt++;
                current.push(fretNum);
            }
        }
        System.out.println(moveCnt);
    }
}

//TODO: 각 줄마다 프렛 상태를 스택으로 관리한다.
// 메모리 121948KB / 시간 616ms
