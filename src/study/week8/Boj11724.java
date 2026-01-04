package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11724 {

    static int N, M;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int size = 0;

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
                size++;
            }
        }

        System.out.println(size);
    }

    static void BFS(int V) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            int nodeIdx = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[nodeIdx][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}

//TODO: 방향 없는 그래프에서 연결된 그룹의 개수 세기
// 메모리 116580KB 시간 492ms
/*
 * 알고리즘: BFS
 * 방문 안 한 노드마다 BFS 실행 -> 실행 횟수 = 연결 요소 개수
 */
