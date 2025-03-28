package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1068 {

  static List<Integer>[] tree;
  static int leafCnt = 0;
  static int deleteNode;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    tree = new List[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      tree[i] = new ArrayList<>();
    }

    int root = 0;
    for (int i = 0; i < N; i++) {
      int p = Integer.parseInt(st.nextToken());
      if (p == -1) {
        root = i;
      } else {
        tree[p].add(i);
      }
    }

    deleteNode = Integer.parseInt(br.readLine());
    dfs(root);
    System.out.println(leafCnt);
  }

  static void dfs(int node) {
    if (node == deleteNode) {
      return;
    }

    int childCnt = 0;

    for (int child : tree[node]) {
      if (child != deleteNode) {
        childCnt++;
        dfs(child);
      }
    }

    if (childCnt == 0) {
      leafCnt++;
    }
  }
}

// 시간 116ms
