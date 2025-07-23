package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N + 1][3];
        int mod = 9901;

        DP[1][0] = 1; // i번째 줄 아무도 X
        DP[1][1] = 1; // 왼쪽에 사자
        DP[1][2] = 1; // 오른쪽에 사자

        for (int i = 2; i <= N; i++) {
            DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) % mod;
            DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % mod;
            DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % mod;
        }

        System.out.println((DP[N][0] + DP[N][1] + DP[N][2]) % mod);
    }
}

// 메모리 17616KB 시간 112ms
