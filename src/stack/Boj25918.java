package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj25918 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String S = br.readLine();
    Stack<Character> stack = new Stack<>();
    int day=0;

    for(int i=0;i<N;i++){
      char c= S.charAt(i);
      if(stack.isEmpty()||stack.peek()==c){
        stack.push(c);
      }else{
        stack.pop();
      }

      day=Math.max(day,stack.size());
    }

    if(stack.isEmpty()){
      System.out.println(day);
    }
    else{
      System.out.println(-1);
    }
  }
}

// 시간 220ms (스케너랑 150ms 이상 차이/BufferedReader 쓰자..)

/*
(X) -> OO와 같고
)O( -> XX와 같다
같은 괄호가 나오면 계속 push
반대가 나오면 pop으로 제거
 */