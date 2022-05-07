package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14716 {
    static int[][] arr;
    static boolean[][] visit;
    static Queue<Point> qu;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, -1, 0, 1};
    static int count;
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        arr = new int[n][m];
        visit = new boolean[n][m];
        qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visit[i][j]){
                    bfs(new Point(i, j));
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(Point point) {
        qu.offer(point);
        visit[point.x][point.y] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for(int i =0; i<8; i++){
                int nx = p.x+ dx[i];
                int ny = p.y+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(arr[nx][ny] == 1 && !visit[nx][ny]){
                    qu.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
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
