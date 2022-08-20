package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMovement {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int[] dx = {-1,-2,-2,-1,1,2,2,1};
         int[] dy = {-2,-1,1,2,2,1,-1,-2};
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < num; i++) {

            int length = Integer.parseInt(br.readLine());
            int[][] arr = new int[length][length];
            boolean[][] visit = new boolean[length][length];
            Queue<Point> qu = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken(" "));
            int m = Integer.parseInt(st.nextToken(" "));
 
            st = new StringTokenizer(br.readLine());

            int on = Integer.parseInt(st.nextToken(" "));  //목적지 x좌표
            int om = Integer.parseInt(st.nextToken(" "));  //목적지 y좌표
            
            
            arr[n][m] = 1;
            visit[n][m] = true;
            qu.offer(new Point(n, m));

            while(true){
                Point p =qu.poll();

                for (int k = 0; k < 8; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];



                    if(nx<0 || nx>=length || ny<0 || ny>= length) continue;

                    if(!visit[nx][ny]){
                        qu.offer(new Point(nx, ny));
                        visit[nx][ny] = true;
                        arr[nx][ny] = arr[p.x][p.y] +1;
                    }
                }

                if(p.x == on && p.y ==om){
                    sb.append(arr[p.x][p.y]-1).append('\n');
                    break;
                }

            }

        }
        System.out.println(sb);
    }
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
