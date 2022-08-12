package com.company.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    public static void main(String[] args) {

        int n = 6;
        int m = 4;

        int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}
        ,{0,0,0,3}, {0,0,0,3}};
//       [[1, 1, 1, 0],
//        [1, 2, 2, 0],
//        [1, 0, 0, 1],
//        [0, 0, 0, 1],
//        [0, 0, 0, 3],
//        [0, 0, 0, 3]]

        solution(n, m, picture);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visit[i][j]){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea , bfs(new Point(i, j, picture[i][j]), m, n, picture));
                    numberOfArea ++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
        return answer;
    }

    private static int bfs(Point p, int n, int m, int[][] picture) {
        int count = 0;

        Queue<Point> qu = new LinkedList<>();

        qu.offer(p);
        visit[p.x][p.y] = true;
        count ++;
        while (!qu.isEmpty()) {
            Point point = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (picture[nx][ny] == point.type && !visit[nx][ny]) {
                        qu.offer(new Point(nx, ny, picture[nx][ny]));
                        count ++;
                        visit[nx][ny] = true;
                    }
                }
            }

        }
        return count;
    }

    static class Point{
        int x;
        int y;
        long type;
        public Point(int x, int y, long type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
