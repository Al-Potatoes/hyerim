package study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15810 {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        long minTime = (long) A[0]*M;
        System.out.println(findMinTimeSearch(minTime));
    }

    public static long findMinTimeSearch(long max) {
        long start = 1, end = max;
        while (start < end) {
            long mid = (start + end) / 2;

            long count = 0;
            for (int i = 0; i < N; i++) {
                count += mid / A[i];
            }

            if (count >= M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

//TODO: M개 풍선 만드는 최소 시간 구하기
// 메모리 92344KB 시간 1052ms
// long minTime = (long) A[0]*M;
// **우변에서 (long)으로 안 감싸면 오류남**
