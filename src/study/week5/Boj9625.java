package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int[] cntA = new int[k + 2];
        int[] cntB = new int[k + 2];

        cntA[0] = 1;
        cntB[0] = 0;

        if (k >= 1) {
            cntA[1] = 0;
            cntB[1] = 1;
        }

        for (int i = 2; i <= k; i++) {
            cntA[i] = cntA[i - 1] + cntA[i - 2];
            cntB[i] = cntB[i - 1] + cntB[i - 2];
        }

        int countA = cntA[k];
        int countB = cntB[k];

        System.out.println(countA + " " + countB);
    }
}

// 메모리 15916KB 시간 116ms
/*
A
B
BA
BAB
BABBA
like 피보나치 수열
 */
