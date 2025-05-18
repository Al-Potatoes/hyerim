package week.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468 {

    static int N;
    static int[][] X;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0}; // 행을 이동 (상하)
    static int[] dCol = {0, 0, -1, 1}; // 열을 이동 (좌우)

    public static void dfs(int x, int y, int depth) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dRow[k], ny = y + dCol[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && X[nx][ny] > depth) {
                if(!visited[nx][ny])
                    dfs(nx,ny,depth);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int maxDepth = 0;
        X = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                X[i][j] = Integer.parseInt(st.nextToken());
                maxDepth = Math.max(maxDepth, X[i][j]);
            }
        }

        int maxCnt = 0;
        for (int depth = 0; depth < maxDepth; depth++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && X[i][j] > depth) {
                        dfs(i, j, depth);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }
}

// 메모리 19512KB
// 시간 229ms
