package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj1620 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Map<Integer, String> pokemon1 = new HashMap<>();
    Map<String, Integer> pokemon2 = new HashMap<>();
    StringBuilder sb=new StringBuilder();

    for (int i = 1; i <= N; i++) {
      String input = br.readLine();
      pokemon1.put(i, input);
      pokemon2.put(input, i);
    }

    for (int i = 1; i <= M; i++) {
      String input = br.readLine();
      if (input.matches("[0-9]+")) {
        sb.append(pokemon1.get(Integer.parseInt(input)));
      } else {
        sb.append(pokemon2.get(input));
      }
      sb.append('\n');
    }

    System.out.println(sb);
  }
}

// 메모리 158392KB
// 시간 720ms
