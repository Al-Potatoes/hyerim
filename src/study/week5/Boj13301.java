package study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj13301 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println("4");
            return;
        }
        System.out.println(tileSize(1, 1, N));
    }

    public static long tileSize(long a, long b, int N) {
        if (N == 2) {
            return 2*a+4*b;
        }
        return tileSize(b, a + b, N - 1);
    }
}

// 메모리 14288KB 시간 104ms
