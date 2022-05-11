package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No21736 {
    static int n, m;
    static char[][] arr;
    static boolean[][] visit;
    static int count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> qu;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        arr = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'I'){
                    bfs(new Point(i,j));
                }
            }
        }
        System.out.println(count>0? count: "TT");
    }

    private static void bfs(Point point) {
        qu.offer(point);
        visit[point.x][point.y] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(arr[nx][ny] != 'X' && !visit[nx][ny]){
                    qu.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                    if(arr[nx][ny] == 'P') count++;
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
