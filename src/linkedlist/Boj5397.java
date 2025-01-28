package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj5397 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      LinkedList<Character> list = new LinkedList<>();
      ListIterator<Character> iterator = list.listIterator();

      for (char c : input.toCharArray()) {
        switch (c) {
          case '<':
            if (iterator.hasPrevious()) {
              iterator.previous();
            }
            break;

          case '>':
            if (iterator.hasNext()) {
              iterator.next();
            }
            break;

          case '-':
            if (iterator.hasPrevious()) {
              iterator.previous();
              iterator.remove();
            }
            break;

          default:
            iterator.add(c);
            break;
        }
      }

      for (char c : list) {
        sb.append(c);
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }
}
