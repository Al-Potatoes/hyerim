package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13335 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    Queue<Integer> trucks=new LinkedList<Integer>();
    Queue<Integer> bridge= new LinkedList<Integer>();

    int n = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    st=new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      trucks.offer(Integer.parseInt(st.nextToken()));
    }

    for(int i=0;i<w;i++){
      bridge.offer(0);
    }
    int time=0,weight=0;
    while(!trucks.isEmpty()||weight>0){
      time++;
      weight-=bridge.poll();

      if(!trucks.isEmpty()){
        if(weight+trucks.peek()<=L){
          int next=trucks.poll();
          bridge.offer(next);
          weight+=next;
        }else{
          bridge.offer(0);
        }
      }
    }

    System.out.println(time);
  }
}
