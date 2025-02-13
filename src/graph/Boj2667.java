package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj2667 {
  static int[][] home;
  static boolean[][] visited;
  static int N;
  static int[] dRow={-1,1,0,0}; // 행을 이동 (상하)
  static int[] dCol={0,0,-1,1}; // 열을 이동 (좌우)


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    home =new int[N][N];
    visited=new boolean[N][N];

    for(int i=0;i<N;i++){
      String line=br.readLine();
      for(int j=0;j<N;j++){
        home[i][j] = line.charAt(j) - '0';
      }
    }

    List<Integer>size=new ArrayList<>();

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(home[i][j]==1&&!visited[i][j]){
          size.add(BFS(i,j));
        }
      }
    }

    Collections.sort(size);

    System.out.println(size.size());
    for(int x:size){
      System.out.println(x);
    }
  }
  public static int BFS(int row,int col) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{row,col});
    visited[row][col] = true;
    int cnt=1;

    while (!q.isEmpty()) {
      int []now=q.poll();
      int nowX=now[0],nowY=now[1]; // 현재 좌표

      for(int i=0;i<4;i++){
        int nx=nowX+dRow[i],ny=nowY+dCol[i]; // 상하좌우 이동한 칸 조사
        if(nx>=0&&nx<N&&ny>=0&&ny<N){
          if(home[nx][ny]==1&&!visited[nx][ny]){
            visited[nx][ny]=true;
            q.offer(new int[]{nx,ny});
            cnt++;
          }
        }
      }
    }

    return cnt;
  }
}

// 시간 116ms