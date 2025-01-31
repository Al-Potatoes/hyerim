package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj30885 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    LinkedList<LinkedList<Long>> list = new LinkedList<>();

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      LinkedList<Long> m = new LinkedList<>();
      m.addLast(Long.parseLong(input[i]));
      m.addLast((long) i + 1);
      list.addLast(m);
    }

    while (list.size() > 1) {
      LinkedList<LinkedList<Long>> nextDay = new LinkedList<>();
      LinkedList<Long> prev = new LinkedList<>();
      prev.add(0L);

      while (!list.isEmpty()) {
        LinkedList<Long> curr = list.getFirst();
        list.removeFirst();
        long size = curr.getFirst();

        if (prev.getFirst() > 0) {
          if (curr.getFirst() >= prev.getFirst()) size += prev.getFirst();
          else nextDay.addLast(prev);
        }

        if (!list.isEmpty()) {
          LinkedList<Long> next = list.getFirst();
          if (curr.getFirst() >= next.getFirst()) {
            size += next.getFirst();
            list.removeFirst();
          }
        }

        curr.removeFirst();
        curr.addFirst(size);
        prev = curr;
      }

      if (prev.getFirst() > 0) nextDay.add(prev);
      list = nextDay;
    }

    System.out.println(list.getLast().getFirst());
    System.out.println(list.getLast().getLast());
  }
}
