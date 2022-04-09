package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class No2583 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();

        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());


            for(int j = 0; j < n; j++){
                for (int k = 0; k<m ;k++){
                    if(k>= lx && k<rx && j>=n-ry && j<n-ly){
                        map[j][k] = 1;
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Point> qu = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        int sum=0;
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (map[i][j] == 0 && !visit[i][j]) {

                   qu.offer(new Point(i, j));
                   visit[i][j] = true;
                   count++;
                   sum = 1;


               while (!qu.isEmpty()) {

                   Point p = qu.poll();
                   map[p.x][p.y] += 1;
                   for (int k = 0; k < 4; k++) {
                       int nx = p.x + dx[k];
                       int ny = p.y + dy[k];

                       if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                       if (map[nx][ny] == 0 && !visit[nx][ny]) {
                           sum++;
                           qu.offer(new Point(nx, ny));
                           map[nx][ny] = map[p.x][p.y] + 1;
                           visit[nx][ny] = true;
                       }

                   }

               }

               list.add(sum);
               }
           }
        }
        Collections.sort(list);
        list.stream().forEach(integer-> sb.append(integer+" "));
        System.out.println(count);
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
