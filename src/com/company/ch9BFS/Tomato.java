package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 1 ){
                    qu.offer(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }
        int day = 0;
        int[] dx =  {0 , 1, -1 , 0};
        int[] dy =  {1 , 0, 0 , -1};

        while(!qu.isEmpty()){
           Point p =  qu.poll();

           for(int i =0; i<4; i++){
               int nx = p.x + dx[i];
               int ny = p.y + dy[i];


               if(nx <0 || nx>= n || ny<0 || ny>=m){
                   continue;
               }

               if(box[nx][ny] == 0 && !visit[nx][ny]){
                   qu.offer(new Point(nx, ny));
                   visit[nx][ny] = true;
                   box[nx][ny] = box[p.x][p.y] +1;
               }
               day = Math.max(day, box[p.x][p.y]);
           }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        if(day ==1){
            System.out.println(0);
            return;
        }else{
            System.out.println(day-1);
            return;
        }

    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
