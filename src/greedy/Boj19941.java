package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String string = br.readLine();
        char[] x = string.toCharArray();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (x[i] == 'P') {
                for (int j = Math.max(0, i - K); j <= Math.min(i + K, N - 1); j++) {
                    if (x[j] == 'H') {
                        cnt++;
                        x[j] = 'X';
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

// 메모리 14424KB 시간 112ms
