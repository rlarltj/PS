package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken(" "));
        int n = Integer.parseInt(st.nextToken(" "));

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        Queue<Point> qu = new LinkedList<>();

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    qu.offer(new Point(i, j));
                }
            }
        }

        while(!qu.isEmpty()){
            Point p = qu.poll();

            for(int k = 0; k<4; k++){
                int nx = dx[k] + p.x;
                int ny = dy[k] + p.y;

                if(nx<0 || nx>= n || ny<0 || ny>=m){
                    continue;
                }

                if(arr[nx][ny] == 0){
                    qu.offer(new Point(nx, ny));
                    arr[nx][ny] = arr[p.x][p.y] +1;
                }

            }
        }

        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    System.exit(0);
                }

                day = Math.max(day, arr[i][j]);
            }
        }

        if(day == 1){
            System.out.println(0);
            System.exit(0);
        }else{
            System.out.println(day-1);
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
