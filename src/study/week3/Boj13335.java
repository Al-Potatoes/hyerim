package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int weight = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        while (!truck.isEmpty()) {
            cnt++;
            weight -= bridge.poll();
            if (!truck.isEmpty()) {
                if (weight + truck.peek() <= L) {
                    weight += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }
        System.out.println(cnt+w);
    }
}

// 메모리 15252KB 시간 120ms
/*
4 2 10
7 4 5 6

7
45
0
1초
먼저 시작해
큐에서 7pop해 근데 그 다음게 4니까 실행못해
그러니까 두칸을 다가버려
다음거 4시작해 근데 다음 peek을해도 10을 안넘으니까 5도 같이가
*/

