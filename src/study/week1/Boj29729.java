package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj29729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < N + M; i++){
            int kind = Integer.parseInt(br.readLine());
            if(kind==1){
                cnt++;
                if(cnt>S){
                    S*=2;
                }
            }else {
                cnt--;
            }
        }

        System.out.println(S);
    }
}

//TODO: (브론즈3) 가변 배열에 대해 학습하고 Jagged Array를 구현해보자.(https://hianna.tistory.com/518)
// 첫 시도 메모리 27929KB / 시간 208ms
/*
1 5 1
1
1
1
1
0
1
 */
