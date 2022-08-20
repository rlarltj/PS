package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576V2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken(" "));
        int n = Integer.parseInt(st.nextToken(" "));

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        Queue<Pair> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1){
                    qu.offer(new Pair(i, j));
                }
            }
        }

        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1 , 0, -1};
        int day = 0;

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }

                if(arr[nx][ny] == 0 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[p.x][p.y]+1;
                    qu.offer(new Pair(nx, ny));
                }
            }

        }

        for(int i =0; i<n; i++){
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }

                day = Math.max(day, arr[i][j]);
            }
        }
        if(day == 1){
            System.out.println(0);
            return;
        }else{
            System.out.println(day-1);
            return;
        }
    }
    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
