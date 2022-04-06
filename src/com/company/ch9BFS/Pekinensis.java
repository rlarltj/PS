package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pekinensis {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken(" "));
            int n = Integer.parseInt(st.nextToken(" "));
            int num = Integer.parseInt(st.nextToken(" "));
            int[][] arr = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            int count = 0;

            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken(" "));
                int q = Integer.parseInt(st.nextToken(" "));
                arr[q][p] = 1;
            }
            // 배추 위치 표시 완료
            Queue<Point> qu = new LinkedList<>();
            int[] dx = {1, 0 , -1, 0};
            int[] dy = {0, 1 , 0, -1};
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    if(arr[j][k] == 1 && !visit[j][k]){
                        qu.offer(new Point(j,k));
                        visit[j][k] = true;
                        count++;
                    }

                        while(!qu.isEmpty()){
                            Point p = qu.poll();
                            for(int r = 0; r<4; r++){
                                int nx = p.x+dx[r];
                                int ny = p.y+dy[r];


                                if(nx <0 || nx>=n || ny<0 || ny>= m){
                                    continue;
                                }

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
