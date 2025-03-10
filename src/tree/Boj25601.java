package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj25601 {

  static TreeMap<String, List<String>> tree;
  static TreeMap<String, Integer> visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    tree = new TreeMap<>();
    visited = new TreeMap<>();

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String c = st.nextToken();
      String p = st.nextToken();
      tree.putIfAbsent(c, new ArrayList<>());
      tree.putIfAbsent(p, new ArrayList<>());
      tree.get(c).add(p);
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    String u = st.nextToken();
    String v = st.nextToken();

    int up = dfs(u, v);
    visited.clear();
    int down = dfs(v, u);
    //System.out.println(up+" "+down);
    System.out.println(up == 1 || down == 1 ? 1 : 0);  }

  private static int dfs(String u, String v) {
    if (u.equals(v)) return 1;
    visited.put(u,1);

    List<String> list = tree.get(u);
    for(String next:list){
      if(!visited.containsKey(next)){
        if(dfs(next,v)==1) return 1;
      }
    }

    return 0;
  }
}

// 시간 604ms