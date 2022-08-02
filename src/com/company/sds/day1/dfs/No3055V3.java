package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055V3 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist;
    static char[][] map;
    static boolean[][] visit;
    static Queue<Point> qu;
    static boolean flag;
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        map = new char[n][m];
        visit = new boolean[n][m];
        qu = new LinkedList<>();
        dist = new int[n][m];

        Point po = null;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == '*'){
                    //큐에 물을 먼저 넣는다.
                    qu.offer(new Point(i, j, '*'));
                }

                if(map[i][j] == 'S'){
                    po = new Point(i, j, map[i][j]);
                }
            }
        }
        //큐에 고슴도치를 두번째로 넣는다.
        qu.offer(po);
        bfs();
    }

    private static void bfs() {

        while (!qu.isEmpty()) {
        // 1. 체크인
            Point p = qu.poll();

        // 2. 목적지인가
            if(p.type == 'D'){
                flag = true;
                max = dist[p.x][p.y];
                break;
            }

        // 3. 순회 가능한 곳
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

        // 4. 갈 수 있는가
            //공통: 맵 안 범위
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    //물 : S, . , !visit
                    if(p.type == 'S' || p.type == '.'){
                        if((map[nx][ny] == '.' || map[nx][ny] =='D')  && dist[nx][ny] == 0){
                            qu.offer(new Point(nx, ny, map[nx][ny]));
                            dist[nx][ny] = dist[p.x][p.y] + 1;
                        }
                    }

                    if(p.type == '*'){
                        if(map[nx][ny] == '.' || map[nx][ny] == 'S'){
                            map[nx][ny] = '*';
                            qu.offer(new Point(nx, ny, map[nx][ny]));
                        }
                    }
                    //도치: D, . , !visit , *이 아닌 곳
                }
            }
        }
        if(flag){
            System.out.println(max);
        }else{
            //도달하지 못한 경우
            System.out.println("KAKTUS");
            return;
        }
    }

    static class Point{
        int x;
        int y;
        char type;

        public Point(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
