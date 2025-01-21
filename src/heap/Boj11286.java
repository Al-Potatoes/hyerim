package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj11286 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
      if(Math.abs(a)==Math.abs(b)){
        return Integer.compare(a,b);
      }
      return Integer.compare(Math.abs(a),Math.abs(b));
    });
    for(int i=0;i<N;i++){
      int num=Integer.parseInt(br.readLine());
      if(num!=0){
        pq.offer(num);
      }else{
        if(pq.size()==0){
          System.out.println("0");
        }else{
          System.out.println(pq.poll());
        }

      }
    }
  }
}
