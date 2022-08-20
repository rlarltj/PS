package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16948 {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int n;
    static Queue<Point> qu;
    static int[][] arr;
    static boolean[][] visit;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken(" "));
        int y = Integer.parseInt(st.nextToken(" "));

        Point start = new Point(x, y);

        x = Integer.parseInt(st.nextToken(" "));
        y = Integer.parseInt(st.nextToken(" "));
        Point fin = new Point(x, y);
        count = 0;
        arr = new int[n][n];
        visit = new boolean[n][n];
        qu = new LinkedList<>();
        bfs(start, fin);
        System.out.println(arr[fin.x][fin.y]);
    }

    private static void bfs(Point start, Point fin) {
        qu.offer(start);
        visit[start.x][start.y]= true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx <0 || ny<0 || nx>=n || ny>=n) continue;

                if(!visit[nx][ny]){
                    qu.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[p.x][p.y] + 1;
//                    bfs(new Point(nx, ny), fin);
                }

                if(nx == fin.x && ny == fin.y){

                    return;
                }
            }
        }
        System.out.println(-1);
        System.exit(0);
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
