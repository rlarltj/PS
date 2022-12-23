package com.company.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No4485 {
    static int T;
    static int N;
    static int[][] dist;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            dist = new int[N + 1][N + 1];
            map = new int[N + 1][N + 1];
            check = new boolean[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                Arrays.fill(dist[i], INF);
            }

            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dijks(1);

            sb.append("Problem" + " " + num++ + ": " + dist[N][N] + '\n');
        }

        System.out.println(sb);
    }

    private static void dijks(int start) {
        PriorityQueue<Point> qu = new PriorityQueue<>();
        //시작점
        qu.offer(new Point(1, 1, map[1][1]));

        dist[start][start] = map[1][1];

        while (!qu.isEmpty()) {
            Point cur = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                    continue;
                }

                if (check[nx][ny]) {
                    continue;
                }

                if (dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];

                    qu.offer(new Point(nx, ny, dist[nx][ny]));
                }
            }
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
