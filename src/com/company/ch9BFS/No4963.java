package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4963 {
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken(" "));
            int n = Integer.parseInt(st.nextToken(" "));
            count = 0;
            if(n ==0 && m ==0) break;

            int[][] arr = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            Queue<Point> qu = new LinkedList<>();
            int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
            int[] dy = {1, 0, -1, 1, -1, 0, 1, -1};

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken(" "));
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && !visit[i][j]){
                        qu.offer(new Point(i,j));
                        visit[i][j] = true;
                        count++;
                    }


                    while(!qu.isEmpty()){
                        Point p = qu.poll();

                        for (int k = 0; k < 8; k++) {
                            int nx = p.x+ dx[k];
                            int ny = p.y+ dy[k];

                            if(nx <0 || nx>=n || ny<0 || ny>=m) continue;

                            if(arr[nx][ny] == 1 && !visit[nx][ny]){
                                qu.offer(new Point(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        sb.append(count).append('\n');
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
