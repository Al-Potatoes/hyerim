package week.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj4375 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            long num = 1;
            int cnt = 1;
            while (num % n != 0) {
                num = num * 10 + 1;
                cnt++;
                num %= n;
            }
            System.out.println(cnt);
        }
    }
}

// 메모리 14144KB
// 시간 96ms
