package study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());

        Set<Integer> A = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numA; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numB; i++) {
            A.remove(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A.size()).append("\n");

        for (int num : A) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}

//TODO: A-B 차집합(TreeSet으로 정렬까지)
// 메모리 171932KB 시간 1280ms
