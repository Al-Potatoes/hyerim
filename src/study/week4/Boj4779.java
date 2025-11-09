package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj4779 {

    static char [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {

            int N = Integer.parseInt(line);
            int length = (int) Math.pow(3, N);
            arr = new char[length];
            Arrays.fill(arr, '-');
            cantor(0, length, arr);
            System.out.println(arr);
        }
    }

    public static void cantor(int s, int length, char arr[]) {
        if (length == 1) {
            return;
        }

        int newSize = length / 3;
        int middle = s + newSize;
        for (int i = middle; i < middle + newSize; i++) {
            arr[i] = ' ';
        }

        cantor(s, newSize, arr);
        cantor(middle + newSize, newSize, arr);
    }
}

//TODO: 먼저 3^N을 만들고 '-'로 채운 뒤 가운데를 공백으로 없애는 로직(재귀)
// 메모리 18796KB 시간 176ms
