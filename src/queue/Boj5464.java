package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5464 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int sum=0;
    int []weights = new int[M];
    int []rates = new int[N];
    int []spaces = new int[N];
    Queue<Integer> waiting = new LinkedList<>();

    for(int i=0;i<N;i++){
      rates[i]=Integer.parseInt(br.readLine());
    }
    for(int i=0;i<M;i++){
      weights[i]=Integer.parseInt(br.readLine());
    }
    for(int i=0;i<2*M;i++){
      int car=Integer.parseInt(br.readLine());

      if(car>0){
        boolean parked=false;

        for(int j=0;j<N;j++){
          if(spaces[j]==0){
            spaces[j]=car;
            sum+=rates[j]*weights[car-1];
            parked=true;
            break;
          }
        }

        if(!parked){
          waiting.add(car);
        }
      }else{
        car=Math.abs(car);

        for(int j=0;j<N;j++){
          if(spaces[j]==car){
            spaces[j]=0;
            break;
          }
        }

        if(!waiting.isEmpty()){
          int next=waiting.poll();
          for(int j=0;j<N;j++){
            if(spaces[j]==0){
              spaces[j]=next;
              sum+=rates[j]*weights[next-1];
              break;
            }
          }
        }
      }
    }

    System.out.println(sum);
  }
}

// 132ms