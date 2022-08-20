package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No1941 {
    static char[][] arr = new char[5][5];
    static boolean[][] visit = new boolean[5][5];
    static Queue<Point> qu;
    static List<Character> answer;
    static int count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!visit[i][j]){
                    answer = new ArrayList<>();
                    qu = new LinkedList<>();
                    bfs(new Point(i, j));
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(Point point) {
        answer.add(arr[point.x][point.y]);
        if(answer.size() == 7){
            long c = answer.stream().filter(a -> a == 'S').count();
            System.out.println(c);

            if(c >= 4) {
            System.out.println(answer);
                count++;
            }
            return ;
        }
        qu.offer(point);
        visit[point.x][point.y] = true;

        while(!qu.isEmpty()){
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x+ dx[i];
                int ny = p.y+ dy[i];

                if(nx<0 || ny<0 || nx>=5 || ny>= 5) continue;
                if(!visit[nx][ny]){
                    bfs(new Point(nx, ny));
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
