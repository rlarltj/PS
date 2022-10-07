package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2206 {
    static int n, m;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        bfs(new Point(0, 0, 1,false));

    }

    private static void bfs(Point point) {
        Queue<Point> qu = new LinkedList<>();
        qu.offer(point);

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                //종점인 경우
                System.out.println(p.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                //맵 밖에 범위인 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                int nextDistance = p.distance + 1;

                if (map[nx][ny] == '1') {
                    if (!p.destroyed) {
                        qu.offer(new Point(nx, ny, nextDistance, true));
                        visit[nx][ny][1] = true;
                    }
                }

                else if (map[nx][ny] == '0') {
                    if(!p.destroyed && !visit[nx][ny][0]){
                        qu.offer(new Point(nx,ny, nextDistance, false));
                        visit[nx][ny][0] = true;
                    }else if(p.destroyed && !visit[nx][ny][1]){
                        qu.offer(new Point(nx, ny, nextDistance, true));
                        visit[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Point{
        int x;
        int y;
        int distance;
        boolean destroyed;

        public Point(int x, int y, int distance, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.destroyed = destroyed;
        }
    }
}
