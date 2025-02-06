package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj17619 {
  static int[] parent;
  static int[] maxRight;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    int[][] logs = new int[N][4];
    parent = new int[N];
    maxRight = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      logs[i][0] = Integer.parseInt(st.nextToken()); // x1
      logs[i][1] = Integer.parseInt(st.nextToken()); // x2
      logs[i][2] = Integer.parseInt(st.nextToken()); // y
      logs[i][3] = i; // 원래 인덱스 저장
      parent[i] = i;
    }

    // x1 기준으로 정렬
    Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));

    int lastRight = logs[0][1];
    for (int i = 1; i < N; i++) {
      if (logs[i][0] <= lastRight) {
        union(logs[i - 1][3], logs[i][3]); // 현재 통나무와 이전 통나무를 같은 그룹으로 합침
      }
      lastRight = Math.max(lastRight, logs[i][1]); // 현재 그룹의 가장 오른쪽 x2 값 갱신
    }

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      if (find(a) == find(b)) {
        sb.append("1\n");
      } else {
        sb.append("0\n");
      }
    }

    System.out.print(sb);
  }

  static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    int pa = find(a);
    int pb = find(b);
    if (pa != pb) {
      parent[pb] = pa;
    }
  }
}
