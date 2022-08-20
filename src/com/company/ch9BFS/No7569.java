package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569 {
    static int n, m, h;
    static int[][][] arr;
    static Queue<Point> qu;
    static int[] dx = {1, 0 ,-1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken(" "));
        n = Integer.parseInt(st.nextToken(" "));
        h = Integer.parseInt(st.nextToken(" "));

        arr = new int[h][n][m];
        qu = new LinkedList<>();
        //5 3 2
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken(" "));
                    if(arr[k][i][j] == 1) qu.offer(new Point(k,i,j));
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        while(!qu.isEmpty()){
            Point p = qu.poll();

            for (int i = 0; i < 6; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                int nz = p.z+dz[i];

                if(nx<0 || ny<0 || nz<0 || nx>=n || ny>= m || nz>=h) continue;

                if(arr[nz][nx][ny] == 0){
                    qu.offer(new Point(nz, nx, ny));
                    arr[nz][nx][ny] = arr[p.z][p.x][p.y] + 1;
                }
            }
        }
        int ans = -100;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[k][i][j] == 0 ){
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, arr[k][i][j]);
                }
            }
        }

        if(ans == 1){
            System.out.println(0);
        }else{
            System.out.println(ans-1);
        }
    }

    static class Point{
        int x;
        int y;
        int z;

        public Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
