package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []dp = new int[N+1];

        dp[0]=0;
        for(int i=1;i<=N;i++){
            int min = 100000;
            if(i>0&&dp[i-1]+1<min){
                min=dp[i-1]+1;
            }
            if(i>1&&dp[i-2]+1<min){
                min=dp[i-2]+1;
            }
            if(i>4&&dp[i-5]+1<min){
                min=dp[i-5]+1;
            }
            if(i>6&&dp[i-7]+1<min){
                min=dp[i-7]+1;
            }
            dp[i]=min;
        }
        System.out.println(dp[N]);
    }
}

// 메모리 14676KB 시간 112ms
/*
1
2
5
7

i==3
1원: dp[2]+1=2
2원: dp[1]+1=2
최소 2

i==4
1원: dp[3]+1=3
2원: dp[2]+1=2
최소 2
*/

