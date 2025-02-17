package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj28066 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Queue<Integer> q = new LinkedList<>();
    for(int i=1;i<=N;i++){
      q.add(i);
    }
    while(!q.isEmpty()){
      int start=q.poll();
      for(int i=0;i<K-1;i++){
        if(q.isEmpty()){
          System.out.println(start);
          return;
        }
        q.poll();
      }
      q.add(start);
    }
  }
}

// 시간 208ms
