package study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = endSearch(A,num)-startSearch(A,num);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static int startSearch(int[] A, int target) {
        int start = 0, end = A.length;
        while(start<end){
            int mid = (start+end)/2;
            if(A[mid]<target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    public static int endSearch(int[] A, int target) {
        int start = 0, end = A.length;
        while(start<end){
            int mid = (start+end)/2;
            if(A[mid]<=target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}

/*
-> Hash 쓰면 더 간단하게 풀 수 있었음
public class Boj10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }
}

//TODO: HashMap으로 개수 미리 세어두기
// 메모리 172776KB 시간 1028ms -> 이렇게 하면 시간 탐색도 있음
 */

//TODO: startIdx랑 endIdx를 각각의 이분 탐색으로 구하기
// **StringBuilder를 항상 잘 쓰자**
// 메모리 123564KB 시간 1264ms
/*
1 2 2 3 3 3 5
mid = 3
target = 2
3<2
end = mid
end = 3
1 2 2 3
mid = 2
target =2
2<2
end = mid
end = 2
1 2 2
mid = 1
target = 2
2<2
end = mid
end = 1
1 2
mid = 1
target = 2
1<2
return mid

1 2 2 2 2 2 5
mid =3
target = 2
2<=2
start = 4
end = 7
2 2 5
mid = 5
2<=2
start = 6
 */
