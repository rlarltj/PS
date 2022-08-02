package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055 {
    static int n, m;
    static String[][] arr;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Point> qu;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        arr = new String[n][m];
        map = new int[n][m];

        visit = new boolean[n][m];
        qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.split("")[j];
                if(arr[i][j].equals("*")){
                    qu.offer(new Point(i,j, "w"));
                    visit[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j].equals("S")){
                    qu.offer(new Point(i, j, "b"));
                    visit[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }
        bfs();

    }

    private static void bfs() {
        while (!qu.isEmpty()) {
            Point p = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+p.x;
                int ny = dy[i]+p.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny].equals("X")) {
                    continue;
                }
                if(visit[nx][ny]) continue;

                if(p.type.equals("w")  || arr[nx][ny].equals("S")){
                    if(arr[nx][ny].equals(".")){
                        arr[nx][ny] = "*";
                        qu.offer(new Point(nx, ny, "w"));
                        visit[nx][ny] = true;
                    }else if(arr[nx][ny].equals("D")){
                        continue;
                    }
                }

                else{

                    if(arr[nx][ny].equals(".")){
                        qu.offer(new Point(nx, ny, "b"));
                        visit[nx][ny] = true;
                        map[nx][ny] = map[p.x][p.y]+1;

                        max = Math.max(max, map[nx][ny]);
                    }else if(arr[nx][ny].equals("*")){
                        continue;
                    }else if(arr[nx][ny].equals("D")){
                        System.out.println(max+1);
                        return;
                    }
                }
            }

        }

        System.out.println("KAKTUS");

    }

    static class Point{
        int x;
        int y;
        String type;
        public Point(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
