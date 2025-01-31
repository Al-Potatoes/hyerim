package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj3190 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    boolean[][] apples = new boolean[N + 1][N + 1];
    for (int i = 0; i < K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      apples[x][y] = true;
    }

    int L = Integer.parseInt(br.readLine());
    int[] turnT = new int[10001];
    char[] turnD = new char[10001];

    for (int i = 0; i < L; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      char C = st.nextToken().charAt(0);
      turnT[X] = 1;
      turnD[X] = C;
    }

    Deque<int[]> snake = new ArrayDeque<>();
    snake.add(new int[]{1, 1});
    boolean[][] visited = new boolean[N + 1][N + 1];
    visited[1][1] = true;

    int[] dx = {0, 1, 0, -1};  // x방향
    int[] dy = {1, 0, -1, 0};  // y방향
    int dir = 0;  // (0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위)

    int time = 0;
    while (true) {
      time++;

      int[] head = snake.peekFirst();
      int nx = head[0] + dx[dir];
      int ny = head[1] + dy[dir];

      if (nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny]) {
        break;
      }

      snake.addFirst(new int[]{nx, ny});
      visited[nx][ny] = true;

      if (apples[nx][ny]) {
        apples[nx][ny] = false;
      } else {
        int[] tail = snake.pollLast();
        visited[tail[0]][tail[1]] = false;
      }

      if (turnT[time] == 1) {
        if (turnD[time] == 'L') {
          dir = (dir + 3) % 4;
        } else if (turnD[time] == 'D') {
          dir = (dir + 1) % 4;
        }
      }
    }

    System.out.println(time);
  }
}