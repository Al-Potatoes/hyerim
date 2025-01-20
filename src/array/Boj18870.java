package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Boj18870 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] arr2 = new int[N];
    HashMap<Integer, Integer> map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    arr2 = arr.clone();
    Arrays.sort(arr2);

    int idx = 0;
    for (int i = 0; i < N; i++) {
      if (!map.containsKey(arr2[i])) {
        map.put(arr2[i], idx++);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(map.get(arr[i])).append(" ");
    }
    System.out.println(sb.toString());
  }
}
