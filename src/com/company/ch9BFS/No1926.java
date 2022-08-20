package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1926 {
    public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken(" "));
        int col = Integer.parseInt(st.nextToken(" "));

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};


        int[][] arr = new int[row][col];
        boolean[][] visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Pair> qu = new LinkedList<>();
        int count = 0;
        int max = 0;
        int area = 0;
        for(int i =0; i<row; i++){
            for(int j =0; j<col; j++){
                if(arr[i][j] == 0 || visit[i][j]){
                    continue;
                }

                visit[i][j] = true;

                count++;
                qu.offer(new Pair(i,j));
                area = 0;

                while(!qu.isEmpty()){
                    Pair p = qu.poll();
                    area++;

                    for(int k =0; k<4; k++){
                        int nx = p.x+dx[k];
                        int ny = p.y+dy[k];

                        if(nx<0 || nx>=row || ny<0 || ny>=col){
                            continue;
                        }

                        if(arr[nx][ny] == 1 && !visit[nx][ny]){
                            qu.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
                if(area>max){
                    max = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
      }

      public static class Pair{
            int x;
            int y;

              public Pair(int x, int y) {
                  this.x = x;
                  this.y = y;
              }

          public int getX() {
              return x;
          }

          public void setX(int x) {
              this.x = x;
          }

          public int getY() {
              return y;
          }

          public void setY(int y) {
              this.y = y;
          }
      }
}
