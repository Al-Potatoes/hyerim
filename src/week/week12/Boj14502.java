package week.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14502 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0}; // 행을 이동 (상하)
    static int[] dCol = {0, 0, -1, 1}; // 열을 이동 (좌우)
    static List<int[]> Y;

    public static void dfs(int[][] tempMap, int x, int y) {
        visited[x][y] = true;
        tempMap[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dRow[i], ny = y + dCol[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && tempMap[nx][ny] == 0) {
                dfs(tempMap, nx, ny);
            }
        }
    }

    public static void spreadVirus(int[][] tempMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2 && !visited[i][j]) {
                    dfs(tempMap, i, j);
                }
            }
        }
    }

    public static int[][] copyMap() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempMap[i] = Arrays.copyOf(map[i], M);
        }
        return tempMap;
    }

    public static int count(int[][] tempMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Y = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    Y.add(new int[]{i, j});
                }
            }
        }

        int maxCnt = 0;
        int size = Y.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    int[][] tempMap = copyMap();

                    tempMap[Y.get(i)[0]][Y.get(i)[1]] = 1;
                    tempMap[Y.get(j)[0]][Y.get(j)[1]] = 1;
                    tempMap[Y.get(k)[0]][Y.get(k)[1]] = 1;

                    visited = new boolean[N][M];
                    spreadVirus(tempMap);
                    maxCnt = Math.max(maxCnt, count(tempMap));
                }
            }
        }
        System.out.println(maxCnt);
    }
}

// 메모리 52386KB
// 시간 268ms
