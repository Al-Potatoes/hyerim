package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String []patterns=pattern.split("\\*");
        for(int i=0;i<N;i++){
            String fileName=br.readLine();
            if(fileName.startsWith(patterns[0])&&
               fileName.endsWith(patterns[1])&&
               pattern.length()-1<=fileName.length()){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }
    }
}

// 메모리 14208KB
// 시간 108ms
