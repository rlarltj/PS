package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3187 {
    static char[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> qu;
    static int sheep;
    static int wolf;
    static int sheepAns;
    static int wolfAns;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
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
                if((arr[i][j] == 'k' || arr[i][j] == 'v') && !visit[i][j]){
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheepAns+" "+ wolfAns);
    }

    private static void bfs(int x, int y) {
        sheep = 0;
        wolf = 0;
        if(arr[x][y] == 'v'){
            wolf++;
        }else{
            sheep++;
        }

        visit[x][y] = true;
        qu.offer(new Point(x,y));

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny< 0 || nx>= n || ny >= m) continue;

                if(!visit[nx][ny] && arr[nx][ny] != '#'){
                    qu.offer(new Point(nx, ny));
                    visit[nx][ny] = true;

                    if(arr[nx][ny] == 'v'){
                        wolf++;
                    }else if(arr[nx][ny] == 'k'){
                        sheep++;
                    }
                }
            }
        }
        if(sheep <= wolf) {
            wolfAns += wolf;
        }
        if(sheep > wolf){
            sheepAns += sheep;
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
