package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}

// 메모리 14092KB 시간 104ms
/*
그냥 점화식 문제였음 ㅠ
1 2 4 8-1 14-1 26-2 48-4 88-7
 */
