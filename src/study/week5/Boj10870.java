package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonachi(0,1, n));
    }

    public static int fibonachi(int a, int b, int n){
        if(n==0){
            return a;
        }
        return fibonachi(b,a+b,n-1);
    }
}

// 메모리 14132KB 시간 96ms
