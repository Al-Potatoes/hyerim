package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj33557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] A = new long[T];
        long[] B = new long[T];

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            if (multiplication(A[i], B[i]).equals(A[i] * B[i])) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    public static Long multiplication(long a, long b) {

        StringBuffer sum = new StringBuffer();

        while (a>0|| b>0) {
            StringBuffer mul=new StringBuffer();
            long x = a>0 ? a % 10 : 1;
            long y = b>0 ? b % 10 : 1;

            mul.append(x*y);
            a /= 10;
            b /= 10;
            sum.append(mul.reverse());
        }

        return Long.parseLong(sum.reverse().toString());
    }
}

//TODO: (실버5) A, B를 T만큼 입력받아 실제 곱셈과 잘못된 곱셈 결과가 같은지 확인하는 로직을 구현한다.
// 첫 시도 메모리: 15444KB / 시간: 144ms

/*
        1
1 6 3 8 3
----------
1 6 3 8 3
그럼 걍 10으로 나눈 나머지를 구하고 10으로 나누고 그 다음도 그렇게 하고
만약 0이나올 경우엔 다른 값을 1로 임의로 정하면 될 듯
5
1 16383
x: 1 y: 3 x*y: 3 sum: 3
x: 1 y: 8 x*y: 8 sum: 38
x: 1 y: 3 x*y: 3 sum: 383
x: 1 y: 1 x*y: 1 sum: 3831
1 8 7
  8 8
------
16456
 */
