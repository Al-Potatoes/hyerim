package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780 {

    static int N;
    static int[][] paper;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(0, 0, N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    public static void paper(int x, int y, int size) {
        boolean flag = true;
        int num = paper[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (paper[i][j] != num) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            switch (num) {
                case -1:
                    cnt[0]++;
                    break;
                case 0:
                    cnt[1]++;
                    break;
                case 1:
                    cnt[2]++;
                    break;
            }
        } else {
            for (int i = x; i < x+size; i += size/3) {
                for (int j = y; j < y+size; j += size/3) {
                    // System.out.println(x + " " + y + " " + size / 3);
                    paper(i, j, size / 3);
                }
            }
        }
    }
}
