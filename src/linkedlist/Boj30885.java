package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj30885 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    LinkedList<int[]> list = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      list.add(new int[]{num, i + 1});
    }

    // 반복문을 사용하여 흡수할 미생물이 남아 있을 때까지 진행
    while (list.size() > 1) {
      boolean changed = false;  // 변화가 있었는지 체크

      // 미생물들이 서로 흡수하는 과정
      for (int i = 0; i < list.size() - 1; i++) {
        int[] cur = list.get(i);
        int[] next = list.get(i + 1);

        // 앞의 미생물이 뒤의 미생물을 흡수할 수 있는 경우
        if (cur[0] >= next[0]) {
          cur[0] += next[0];  // 크기 합침
          list.remove(i + 1);  // 뒤 미생물 제거
          changed = true;  // 흡수가 이루어졌음을 표시
          break;  // 흡수 후 한 번에 처리되도록 다음 미생물로 넘어감
        }
      }

      if (!changed) break;  // 더 이상 변화가 없으면 종료
    }

    // 결과 출력
    System.out.println(list.get(0)[0]);  // 최종 크기
    System.out.println(list.get(0)[1]);  // 미생물의 초기 위치
  }
}
