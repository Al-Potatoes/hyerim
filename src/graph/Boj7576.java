package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {

  static int[][] tomato;
  static int N, M;
  static int[] dRow = {-1, 1, 0, 0}; // 행을 이동 (상하)
  static int[] dCol = {0, 0, -1, 1}; // 열을 이동 (좌우)

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    tomato = new int[N][M];

    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());
        if (tomato[i][j] == 1) {
          q.add(new int[]{i,j});
        }
      }
    }
    int result=BFS(q);

    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(tomato[i][j]==0){
          System.out.println("-1");
          return;
        }
      }
    }

    System.out.println(result);
  }

  public static int BFS(Queue<int[]> q) {
    int day = -1;

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] now = q.poll();
        int x = now[0], y = now[1];

        for (int k = 0; k < 4; k++) {
          int nx = x + dRow[k], ny = y + dCol[k];
          if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomato[nx][ny] == 0) {
            tomato[nx][ny] = 1;
            q.add(new int[]{nx, ny});
          }
        }
      }
      day++;
    }

    return day;
  }
}

// 시간 584ms