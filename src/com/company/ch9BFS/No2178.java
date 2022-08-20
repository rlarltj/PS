package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2178 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));

        int m = Integer.parseInt(st.nextToken(" "));
        int[][] arr = new int[n+1][m+1];
        boolean[][] visit = new boolean[n+1][m+1];

        Queue<Pair> qu = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            String[] str = br.readLine().split("");
            for(int j = 1; j<=m; j++){
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};


        qu.offer(new Pair(1,1));
        visit[1][1] = true;


                while(!qu.isEmpty()) {
                    Pair p = qu.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = p.x+ dx[k];
                        int ny = p.y+ dy[k];

                        if(nx<0 || nx>n || ny<0 || ny>m){
                            continue;
                        }

                        if(arr[nx][ny] != 0 && !visit[nx][ny]){
                            visit[nx][ny] = true;
                            arr[nx][ny] = arr[p.x][p.y]+1;
                            qu.offer(new Pair(nx, ny));
                        }

                    }

                }
                    System.out.println(arr[n][m]);
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
