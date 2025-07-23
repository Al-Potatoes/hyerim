package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] X = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i][0] = Integer.parseInt(st.nextToken());
            X[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] max = new int[N+1];
        for (int i = 0; i < N; i++) {
            if (i + X[i][0] <= N) {
                max[i + X[i][0]] = Math.max(max[i + X[i][0]], max[i] + X[i][1]);
            }
            max[i + 1] = Math.max(max[i + 1], max[i]);
        }
        System.out.println(max[N]);
    }
}

// TODO: 가장 높은 수익을 구하는 프로그램을 작성하라
/*
만약 중간중간 되게 긴 T에 적은 P를 가지고 있는 함정이 있을 수 있음
DP를 사용하자
*/
