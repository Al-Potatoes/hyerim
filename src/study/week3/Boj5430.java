package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb;
        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            boolean front = true;
            boolean error = false;
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<String> deque = new LinkedList<>();
            if (n > 0) {
                String[] parts = arr.replaceAll("[\\[\\]]", "").split(",");
                for (String x : parts) {
                    deque.addLast(x);
                }
            }
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    front = !front;
                } else if (p.charAt(j) == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                    if (front) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            if (!error) {
                sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(front ? deque.pollFirst() : deque.pollLast());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}

//TODO: R이면 뒤집고 D이면 삭제하는 로직을 구현하라
// 메모리 86180KB 시간 724ms
/*
| 코드                      | 설명                                |
| ----------------------- | --------------------------------- |
| `"a,b,c".split(",")`    | `,` 기준으로 분리 → `["a","b","c"]`     |
| `"a b c".split(" ")`    | 공백 기준 분리                          |
| `"a,,c".split(",")`     | 빈값 포함 → `["a","","c"]`            |
| `"a b   c".split(" +")` | 연속 공백 처리(정규표현식) → `["a","b","c"]` |
| `"a,b,c".split(",", 2)` | 최대 2개로 분리 → `["a","b,c"]`         |
*/
