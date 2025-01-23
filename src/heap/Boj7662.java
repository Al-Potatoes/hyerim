package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(br.readLine());

    char kind;
    int n;

    for(int i=0;i<T;i++){
      int k=Integer.parseInt(br.readLine());
      TreeMap<Integer,Integer> map = new TreeMap<>();

      for(int j=0;j<k;j++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        kind=st.nextToken().charAt(0);
        n=Integer.parseInt(st.nextToken());

        if(kind=='I'){
          map.put(n,map.getOrDefault(n,0)+1);
        }else if(kind=='D'){
          if(map.isEmpty()) continue;

          if(n==-1){
            int num=map.firstKey();
            if(map.get(num)==1){
              map.remove(num);
            }else{
              map.put(num,map.get(num)-1);
            }
          }

          else{
            int num=map.lastKey();
            if(map.get(num)==1){
              map.remove(num);
            }else{
              map.put(num,map.get(num)-1);
            }
          }
        }

      }

      if(map.isEmpty()){
        System.out.println("EMPTY");
      }else{
        System.out.println(map.lastKey()+" "+map.firstKey());
      }
    }

  }

}
