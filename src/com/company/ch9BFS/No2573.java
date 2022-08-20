package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2573 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken(" "));
         m = Integer.parseInt(st.nextToken(" "));

        arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        int count = 0;
        int year = 0;

        while((count = seperateNum()) <2) {
            if (count == 0) {
                year = 0;
                break;
            }
            melt();
            year++;
        }
        System.out.println(year);
    }

    private static void melt() {
        Queue<IceBerg> qu = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0){
                    qu.offer(new IceBerg(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int nx, ny;

        while(!qu.isEmpty()){
            IceBerg ice = qu.poll();

            int seaNum=0; //인접한 바다의 수

            for (int i = 0; i < 4; i++) {
                nx = ice.x + dx[i];
                ny = ice.y + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(!visited[nx][ny] && arr[nx][ny] == 0){
                    seaNum++;
                }
            }

            if(arr[ice.x][ice.y] - seaNum<0){
                arr[ice.x][ice.y]=0;
            }else{
                arr[ice.x][ice.y] -= seaNum;
            }
        }
    }

    private static int seperateNum() {
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0 && !visited[i][j]){
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny =y  + dy[i];

            if(nx<0|| ny<0 || nx>=n|| ny>= m) continue;

            if(arr[nx][ny] != 0 && !visited[nx][ny]){
                bfs(nx, ny, visited);
            }
        }

    }
    static class IceBerg{
        int x;
        int y;

        public IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
