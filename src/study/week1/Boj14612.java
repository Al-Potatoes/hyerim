package study.week1;

import java.io.*;
import java.util.*;

public class Boj14612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int n,t;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String kind = st.nextToken();
            switch(kind){
                case "order":
                    n = Integer.parseInt(st.nextToken());
                    t = Integer.parseInt(st.nextToken());
                    list.add(new int[]{n,t});
                    break;
                case "sort":
                    list.sort(Comparator.<int[]>comparingInt(a -> a[1]).thenComparingInt(a -> a[0]));
                    break;
                case "complete":
                    n = Integer.parseInt(st.nextToken());
                    int target = n;
                    list.removeIf(a-> a[0] == target);
                    break;
            }
            if(list.isEmpty()){
                System.out.println("sleep");
            }else{
                for(int [] arr:list){
                    System.out.print(arr[0]+" ");
                }
                System.out.println();
            }
        }
    }
}

//TODO: (실버4) 시간 순서에 맞게 정렬하고 완성하면 포스트잇을 제거하는 로직을 구현하자.(https://shoi.tistory.com/10-> comparator 사용기법)
// 첫 시도 메모리 16352KB / 시간 156ms
