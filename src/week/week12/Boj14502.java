package week.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14502 {

    static int N, M;
    static int[] map;
    static boolean[] visited;
    static int[] dRow = {-1, 1, 0, 0}; // 상하
    static int[] dCol = {0, 0, -1, 1}; // 좌우
    static List<Integer> empty;

    public static void dfs(int[] tempMap, int x, int y) {
        int index = x * M + y;
        visited[index] = true;
        tempMap[index] = 2;

        for (int d = 0; d < 4; d++) {
            int nx = x + dRow[d];
            int ny = y + dCol[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                int nextIndex = nx * M + ny;
                if (!visited[nextIndex] && tempMap[nextIndex] == 0) {
                    dfs(tempMap, nx, ny);
                }
            }
        }
    }

    public static void spreadVirus(int[] tempMap) {
        for (int i = 0; i < N * M; i++) {
            if (tempMap[i] == 2 && !visited[i]) {
                dfs(tempMap, i / M, i % M);
            }
        }
    }

    public static int[] copyMap() {
        return Arrays.copyOf(map, N * M);
    }

    public static int count(int[] tempMap) {
        int cnt = 0;
        for (int value : tempMap) {
            if (value == 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N * M];
        empty = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                int index = i * M + j;
                map[index] = value;
                if (value == 0) {
                    empty.add(index);
                }
            }
        }

        int max = 0;
        int size = empty.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    int[] tempMap = copyMap();
                    tempMap[empty.get(i)] = 1;
                    tempMap[empty.get(j)] = 1;
                    tempMap[empty.get(k)] = 1;

                    visited = new boolean[N * M];
                    spreadVirus(tempMap);
                    max = Math.max(max, count(tempMap));
                }
            }
        }

        System.out.println(max);
    }
}

// 메모리 27304KB
// 시간 212ms
