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
    while(q.size()>K){
      for(int i=0;i<K;i++){
        if(i==0){
          q.offer(q.poll());
        }else{
          q.poll();
        }
      }
    }
    System.out.println(q.poll());
  }
}

// 시간 196ms
