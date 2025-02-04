package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj13164 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N=Integer.parseInt(s[0]);
    int K=Integer.parseInt(s[1]);
    int st[]=new int[N];
    PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
    s = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      st[i]=Integer.parseInt(s[i]);
    }
    for(int i=1;i<N;i++){
      pq.add(st[i]-st[i-1]);
    }
    while(pq.size()>K-1){
      pq.poll();
    }

    int cost=0;
    while(!pq.isEmpty()){
      cost+=pq.poll();
    }

    System.out.println(cost);
  }
}
