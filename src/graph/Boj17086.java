package graph;

import java.io.*;
import java.util.*;

public class Boj17086 {

    static int[][] map;
    static int[][] dist;
    static int N, M;
    static Queue<int[]> q;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 상하
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; // 좌우
    // {↖, ↑, ↗, ←, →, ↙, ↓, ↘}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
                if (map[i][k] == 1) {
                    q.offer(new int[]{i, k});
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        int max = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (dist[nx][ny] == 0 && map[nx][ny] == 0) {
                        dist[nx][ny] = dist[x][y] + 1;
                        max = Math.max(max, dist[nx][ny]);
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return max;
    }
}

// 메모리 14708KB 시간 116ms
