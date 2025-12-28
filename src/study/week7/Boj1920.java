package study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {

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
            sb.append(search(A, num)).append("\n");
        }

        System.out.println(sb);
    }

    public static int search(int[] A, int target) {
        int start = 0, end = A.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==target){
                return 1;
            }else if(A[mid]>target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return 0;
    }
}

//TODO: 이분 탐색으로 존재 여부 확인
// 메모리 43384KB 시간 592ms
// 이분 탐색 내장 함수가 있음
// sb.append(Arrays.binarySearch(A, num) >= 0 ? 1 : 0).append("\n");
// 값을 찾으면 해당 인덱스 반환하는데 아니면 그 삽입위치 + 1에 음수부호를 가짐
// -(삽입위치+1) 요런식으로
