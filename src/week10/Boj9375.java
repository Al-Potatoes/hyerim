package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj9375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int M = Integer.parseInt(br.readLine());
      String[][] clothes = new String[M][2];
      Map<String, Integer> map = new HashMap<>();
      for (int j = 0; j < M; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        clothes[j][0] = st.nextToken();
        clothes[j][1] = st.nextToken();
        map.put(clothes[j][1], map.getOrDefault(clothes[j][1], 0) + 1);
      }
      int res = 1;
      for (int count : map.values()) {
        res *= (count + 1);
      }
      res -= 1;
      System.out.println(res);
    }
  }
}

// 메모리 14212KB
// 시간 108ms

/*
1 a
2 a
3 b
4 c
5 c
1
1,3,4
1,3,5
1,3
1,4
1,5
2
2,3,4
2,3,5
2,3
2,4
2,5
3
3,4
3,5
4
5
 */
