package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj11536 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());
    String []name=new String[N];
    for(int i=0;i<N;i++){
      name[i]=br.readLine();
    }
    String []sort=name.clone();
    String []reverseSort=sort.clone();
    Arrays.sort(sort);
    Arrays.sort(reverseSort, Comparator.reverseOrder());
    if(Arrays.equals(name,sort)){
      System.out.println("INCREASING");
    }
    else  if(Arrays.equals(name,reverseSort)){
      System.out.println("DECREASING");
    }
    else{
      System.out.println("NEITHER");
    }
  }
}
