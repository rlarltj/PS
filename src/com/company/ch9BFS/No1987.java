package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No1987 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;
    static Set<Character> set;
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        map = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(new Point(0, 0, 1));

        System.out.println(max);
    }

    private static void dfs(Point point) {
        visit[point.x][point.y] = true;
        set.add(map[point.x][point.y]);

        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if(set.contains(map[nx][ny]) || visit[nx][ny]){
                continue;
            }
            else{
                dfs(new Point(nx, ny, point.count + 1));
            }


        }
        set.remove(map[point.x][point.y]);
        visit[point.x][point.y] = false;

        max = Math.max(max, point.count);
    }

    static class Point{
        int x;
        int y;
        int count;
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
