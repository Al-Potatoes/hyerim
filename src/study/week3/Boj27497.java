package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj27497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<String> deque=new LinkedList<>();
        Stack<Boolean> history = new Stack<>();
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int kind = Integer.parseInt(st.nextToken());
            switch (kind){
                case 1:
                    String arr = st.nextToken();
                    deque.addFirst(arr);
                    history.push(true);
                    break;
                case 2:
                    arr= st.nextToken();
                    deque.addLast(arr);
                    history.push(false);
                    break;
                case 3:
                    if(!deque.isEmpty()){
                        if (history.pop()){
                            deque.pollFirst();
                        }else{
                            deque.pollLast();
                        }
                    }
                    break;
            }
            //System.out.println(deque);
        }
        if(deque.isEmpty()){
            System.out.println("0");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                sb.append(deque.pollLast());
            }
            System.out.println(sb);
        }
    }
}

// 메모리 242904KB 시간 652ms
