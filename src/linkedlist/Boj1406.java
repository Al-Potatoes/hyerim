package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Boj1406 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<Character> list = new LinkedList<>();

    for (char c : br.readLine().toCharArray()) {
      list.add(c);
    }
    int M = Integer.parseInt(br.readLine());
    ListIterator<Character> iterator=list.listIterator(list.size());


    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char kind = st.nextToken().charAt(0);
      switch (kind) {
        case 'P':
          char x = st.nextToken().charAt(0);
          iterator.add(x);
          break;

        case 'L':
          if(iterator.hasPrevious()){
            iterator.previous();
          }
          break;

        case 'D':
          if (iterator.hasNext()) {
            iterator.next();
          }
          break;

        case 'B':
          if(iterator.hasPrevious()){
            iterator.previous();
            iterator.remove();
          }
          break;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : list) {
      sb.append(c);
    }
    System.out.println(sb);
  }
}
