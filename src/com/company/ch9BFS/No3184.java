package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3184 {
    static int n;
    static int m;
    static String[][] arr;
    static boolean[][] visit;
    static Queue<Point> qu;
    static int[] answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int wolf;
    static int sheep;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        arr = new String [n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.split("")[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && (arr[i][j].equals("v") || arr[i][j].equals("o"))){
                    answer = new int[2];
                    bfs(i,j);
                    if(answer[0] <= answer[1]){
                        wolf+= answer[1];
                    }
                    else if(answer[0]> answer[1]){
                        sheep+= answer[0];
                    }
                }
            }
        }

        System.out.print(sheep+" "+wolf);

    }

    private static void bfs(int x, int y) {

        if(arr[x][y].equals("v")){
            answer[1]++;
        }

        if(arr[x][y].equals("o")){
            answer[0]++;
        }

        qu = new LinkedList<>();
        qu.offer(new Point(x,y));
        visit[x][y] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(arr[nx][ny].equals("#")) continue;
                if(!arr[nx][ny].equals("#") && !visit[nx][ny]){
                    visit[nx][ny] = true;
//                    if(arr[nx][ny].equals("v")) answer[1]++;
//                    else if(arr[nx][ny].equals("o")) answer[0]++;
//
//                    qu.offer(new Point(nx, ny));
                    bfs(nx, ny);
                }
            }

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
