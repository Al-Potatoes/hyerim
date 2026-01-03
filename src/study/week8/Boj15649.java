package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15649 {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        backtracking(new ArrayList<>());

        System.out.print(sb);
    }

    public static void backtracking(List<Integer> sequence) {
        if (sequence.size() == M) {
            for (int num : sequence) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence.add(i);

                backtracking(sequence);

                sequence.remove(sequence.size() - 1);
                visited[i] = false;
            }
        }
    }
}

//TODO: 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 순열을 출력
// 메모리 25372KB 276ms
/*
 * 알고리즘: 백트레킹
 * 핵심 개념:
 *  1. DFS로 깊이 우선 탐색 수열 생성
 *  2. visited 배열로 중복 선택 방지
 *  3. M개 선택 완료 시 출력 후 되돌아가며 다른 경우 수 탐색
 */
