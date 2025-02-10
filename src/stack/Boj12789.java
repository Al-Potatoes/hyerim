package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());
    StringTokenizer st=new StringTokenizer(br.readLine());
    int []arr=new int[N];
    Stack<Integer> stack=new Stack<>();
    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }

    int cnt=1,flag=0;
    for(int i=0;i<N;i++){
      flag=0;
      if(arr[i]==cnt) {
        //System.out.println(cnt);
        cnt++;
        flag = 1;
      }
      if(flag==0||stack.isEmpty()){
        stack.push(arr[i]);
      }
      while (!stack.isEmpty()&&stack.peek() == cnt) {
        stack.pop();
        //System.out.println(cnt);
        cnt++;
      }
    }

    if(cnt==N+1){
      System.out.println("Nice");
    }
    else{
      System.out.println("Sad");
    }
  }
}

// 시간 112ms