package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

    static int N, M;
    static int[][] miro;
    static int[][] distance;
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N + 1][M + 1];
        distance = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = line.charAt(j - 1) - '0';
            }
        }

        System.out.println(BFS(1, 1));
    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        distance[x][y] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0], nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dRow[i], ny = nowY + dCol[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if ((miro[nx][ny] == 1) && distance[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        distance[nx][ny] = distance[nowX][nowY] + 1;
                    }
                }
            }
        }
        return distance[N][M];
    }
}

//TODO: 2차원 최단 거리 미로 탐색
// 메모리 14612 시간 112ms
/*
 * 알고리즘: BFS
 * (1,1)에서 (M,N)까지 최단 경로 구하기
 * distance[next] = distance[current] + 1로 거리 누적
 */
