package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String>[] queues = new Queue[N];
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            queues[i] = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                queues[i].add(st.nextToken());
            }
        }
        StringTokenizer target = new StringTokenizer(br.readLine());
        String targetWord = "";
        while (flag) {
            if (target.hasMoreTokens()) {
                targetWord = target.nextToken();
            } else {
                break;
            }
            flag = false;
            for (int i = 0; i < N; i++) {
                if (targetWord.equals(queues[i].peek())) {
                    queues[i].poll();
                    flag = true;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!queues[i].isEmpty()) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}

//TODO: 앵무새별로 각 큐를 만들어 마지막 문장 L을 각 큐에서 꺼내 완성시킬 수 있는 단어이면 Possible을 출력함(모든 단어가 사용되야함)
// 메모리 22752KB 시간 296ms
