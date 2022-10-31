package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1520 {
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(new Point(1, 1)));
    }

    private static int dfs(Point point) {
        if (dp[point.x][point.y] != -1) {
            return dp[point.x][point.y];
        }

        if (point.x == n && point.y == m) {
            return 1;
        }

        dp[point.x][point.y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];

            if (nx < 1 || ny < 1 || nx > n || ny > m) {
                continue;
            }

            if (map[nx][ny] < map[point.x][point.y]) {
                dp[point.x][point.y] += dfs(new Point(nx, ny));
            }
        }

        return dp[point.x][point.y];
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
