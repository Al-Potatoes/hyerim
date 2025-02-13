package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj2504 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s= br.readLine();
    Stack<Character> stack = new Stack<>();
    int sum=0,tmp=1;

    for(int i=0;i<s.length();i++){
      char c=s.charAt(i);

      switch(c){
        case '(':
          stack.push(c);
          tmp*=2;
          break;
        case '[':
          stack.push(c);
          tmp*=3;
          break;
        case ')':
          if(stack.isEmpty()||stack.peek()!='('){System.out.println(0); return;}
          if(s.charAt(i-1)=='('){
            sum+=tmp;
          }
          stack.pop();
          tmp/=2;
          break;
        case ']':
          if(stack.isEmpty()||stack.peek()!='['){System.out.println(0); return;}
          if(s.charAt(i-1)=='['){
            sum+=tmp;
          }
          stack.pop();
          tmp/=3;
          break;
      }
    }

    if(stack.isEmpty()){
      System.out.println(sum);
    }else{
      System.out.println(0);
    }

  }
}

// 시간 100ms
/*
반례 - ([())] -> 0
 */