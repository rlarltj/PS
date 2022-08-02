package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055V2 {
    static int n, m;
    static int[][] answer;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> qu;
    static boolean flag;
    static int max = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        answer = new int[n][m];
        map = new char[n][m];
        visited = new boolean[n][m];
        qu = new LinkedList<>();

        Point po = null;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j]= s.charAt(j);
                if(map[i][j] == '*'){
                    qu.add(new Point(i, j, '*'));
                }
                if(map[i][j] == 'S'){
                    po = new Point(i, j, map[i][j]);
                }
            }
        }

        qu.add(po);
        bfs();

    }

    private static void bfs() {
        while (!qu.isEmpty()) {
//        1. 큐에서 꺼낸다. --> 꺼낼 수 있는 것은 *, S, ., D 뿐이다.
            Point p = qu.poll();

//        2. 목적지인가? --> D인가?
            if(p.type == 'D'){
                flag = true;
                max = answer[p.x][p.y];
                break;
            }

//        3. 연결된 곳을 순회한다.  --> 상 하 좌 우
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
//        4. 갈 수 있는가? (공통): 범위가 맵 안에 속하는가
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    //갈 수 있는가 (고슴도치) --> ., D, 방문하지 않은 곳
                    if(p.type == 'S' || p.type == '.'){

                        if((map[nx][ny] == '.' || map[nx][ny] == 'D') && answer[nx][ny] == 0){
                            // 체크인 (고슴도치) answer[][] : 이동 거리
                            answer[nx][ny] = answer[p.x][p.y]+1;
                            // 큐에 넣는다
                            qu.offer(new Point(nx, ny, map[nx][ny]));
                        }
                    }

                    //갈 수 있는가 (물) --> '.', 'S'
                    if(p.type == '*'){
                        if(map[nx][ny] == '.' || map[nx][ny] == 'S'){
                            //체크인
                            map[nx][ny] = '*';
                            qu.offer(new Point(nx, ny, '*'));
                        }
                    }
                }
            }
        }
        if(flag){
            System.out.println(max);
        }else{
            System.out.println("KAKTUS");
        }
//        5. 체크인
//        6. 큐에 넣는다.


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
