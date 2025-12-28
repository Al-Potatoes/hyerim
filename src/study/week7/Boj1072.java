package study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1072 {

    static long X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        long Z = Y * 100 / X;

        if(Z>=99){
            System.out.println("-1");
            return;
        }

        System.out.println(startSearch(Z));
    }

    public static long startSearch(long target) {
        long start = 1, end = X;
        while(start<end){
            long mid = (start+end)/2;
            if(((Y+mid)*100/(X+mid))<=target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}

//TODO: 승률 1% 올리는 최소 게임 수 (이분 탐색)
// int는 약 +21억(2,147,483,647)
// Z >= 99면 -1 출력 (더 이상 못 올림)
// 메모리 14408KB 시간 100ms
