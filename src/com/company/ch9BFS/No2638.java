package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2638 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static Queue<Point> qu;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cheeseCnt;
    static int count;
    static ArrayList<Point> cheeseList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        arr = new int[n][m];
        qu = new LinkedList<>();
        cheeseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
                if(arr[i][j] == 1) {
                    cheeseList.add(new Point(i,j));
                    cheeseCnt ++;
                }
            }
        }
        int time = 0;
        while(cheeseCnt != 0){
            time++;
            visit = new boolean[n][m];
            dfs(new Point(0,0));
            melting();
        }

        System.out.println(time);
    }

    private static void melting() {
        for (int i = 0; i < cheeseList.size(); i++) {
            int x = cheeseList.get(i).x;
            int y = cheeseList.get(i).y;
            int cnt = 0;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (arr[nx][ny] == 2) {
                    cnt++;
                }
            }   
                if(cnt >= 2){
                    arr[x][y] = 0;
                    cheeseCnt--;
                    cheeseList.remove(i);
                    i--;
                }
        }
    }


    private static void dfs(Point point) {
        //바깥 공기를 모두 2로 표시한다.
        arr[point.x][point.y] = 2;
        visit[point.x][point.y]  = true;

            for (int i = 0; i < 4; i++) {
                int nx = point.x+dx[i];
                int ny = point.y+dy[i];

                if(nx<0 || ny<0 || nx>= n || ny>=m) continue;
                if(visit[nx][ny] || arr[nx][ny] == 1) continue;

                dfs(new Point(nx, ny));

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
