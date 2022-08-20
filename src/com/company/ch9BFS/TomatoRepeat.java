package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoRepeat {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[n][m];
        int[][] arr = new int[n][m];

        Queue<Point> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    qu.offer(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int day = 0;

        while(!qu.isEmpty()){
            Point p = qu.poll();

            for(int i =0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>= n || ny<0 || ny>=m) continue;

                if(arr[nx][ny] == 0 && !visit[nx][ny]){
                    qu.offer(new Point(nx, ny));
                    arr[nx][ny] = arr[p.x][p.y]+1;
                    visit[nx][ny] = true;
                }
            }

            day = Math.max(day, arr[p.x][p.y]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
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
        }
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
