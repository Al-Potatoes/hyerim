package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj27497 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int []kind=new int[N];
    Deque<Character> deque = new ArrayDeque<Character>();
    int cnt=0;
    for(int i=0;i<N;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      kind[cnt]=Integer.parseInt(st.nextToken());
      switch(kind[cnt]) {
        case 1:
          deque.addLast(st.nextToken().charAt(0));
          cnt++;
          break;
        case 2:
          deque.addFirst(st.nextToken().charAt(0));
          cnt++;
          break;
        case 3:
          if (cnt > 0&& kind[cnt-1] == 1) {
            deque.pollLast();
            cnt--;
          } else if (cnt > 0 && kind[cnt-1] == 2) {
            deque.pollFirst();
            cnt--;
          }
          break;
      }
    }
    if(deque.isEmpty()){
      System.out.println(0);
    }
    else {
      StringBuilder sb = new StringBuilder();
      for (char c : deque) {
        sb.append(c);
      }
      System.out.println(sb);
    }
  }
}

// 시간 608ms