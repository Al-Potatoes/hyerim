package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            switch(c){
                case '1':
                    int pushNum = Integer.parseInt(st.nextToken());
                    stack.push(pushNum);
                    break;
                case '2':
                    if(!stack.empty()) {
                        sb.append(stack.pop()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case '3':
                    sb.append(stack.size()+"\n");
                    break;
                case '4':
                    if(stack.empty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case '5':
                    if(!stack.empty()){
                        sb.append(stack.peek()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}

//TODO: 스택의 각 명령을 잘 처리하는 프로그램을 작성하라
// 메모리 239616KB / 시간 1136ms
