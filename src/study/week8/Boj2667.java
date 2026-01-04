package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2667 {

    static int N;
    static int[][] apt;
    static boolean[][] visited;
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        apt = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                apt[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> size = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apt[i][j] == 1 && !visited[i][j]) {
                    size.add(BFS(i, j));
                }
            }
        }

        Collections.sort(size);
        System.out.println(size.size());
        for (int num : size) {
            System.out.println(num);
        }
    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0], nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dRow[i], ny = nowY + dCol[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (apt[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        size++;
                    }
                }
            }
        }
        return size;
    }
}

//TODO: 2차원 격자에서 연결된 영역 차기 -> 각 영역 크기 구하기
// 메모리 14452KB 시간 104ms
/*
 * 알고리즘: BFS
 * BFS로 상하좌우 연결된 모든 집을 탐색하기
 */
