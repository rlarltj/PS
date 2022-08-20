package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2636 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visit;
    static Queue<Point> qu;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        boolean flag = true;
        int time = 0;
        int firstCount = getCount();
        while(flag){
            time++;
            bfs(new Point(0, 0));

            for (int i = 0; i < n; i++) {
                Arrays.fill(visit[i], false);
            }

            int count = getCount();

            if(count == 0) flag = false;
            else list.add(count);
        }
        System.out.println(time);
        System.out.println(list.size()>0 ? list.get(list.size()-1) : firstCount);
    }

    private static void bfs(Point point) {
        qu = new LinkedList<>();
        qu.offer(point);
        visit[point.x][point.y] = true;

        while(!qu.isEmpty()){
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(arr[nx][ny] == 1 && !visit[nx][ny]){
                    arr[nx][ny] = 2;
                    visit[nx][ny] = true;
                }else if(arr[nx][ny] == 0 && !visit[nx][ny]){
                    qu.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                }

            }
        }
        removeCheese();
    }

    private static void removeCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 2)
                    arr[i][j] = 0;
            }
        }
    }


    private static int getCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) count++;
            }
        }
        return count;
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
