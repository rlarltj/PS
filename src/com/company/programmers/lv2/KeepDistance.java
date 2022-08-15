package com.company.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class KeepDistance {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static String[][] map;
    public static void main(String[] args){
        String[][] arr = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
                         ,{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                         ,{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
                         ,{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                         ,{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                        };

        solution(arr);
    }

    static int[] solution(String[][] places) {
        int[] answer = new int[5];
        Loop1: for (int i = 0; i < 5; i++) {

            int idx = 0;
            String[] arr = places[i];

            map = new String[5][5];

            for (int j = 0; j < 5; j++) {
                map[j] = arr[idx++].split("");
            }

//          {"POOOP",
//           "OXXOX",
//           "OPXPX",
//           "OOXOX",
//           "POXXP"}

            int a = 0;
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(map[j][k].equals("P")){
                        flag = true;
                        visit = new boolean[5][5];
                        a = Math.max(0, bfs(new Point(j, k)));

                        if(a == 0){
                            answer[i] = 0;
                            continue Loop1;
                        }else{
                            answer[i] = 1;
                        }
                    }
                }
            }
            if(!flag){
                answer[i] = 1;
            }
            // 응시자가 아무도 없는 경우
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }

    private static int bfs(Point p) {
        Queue<Point> qu = new LinkedList<>();
        qu.offer(p);
        visit[p.x][p.y] = true;

        while (!qu.isEmpty()) {
            Point point = qu.poll();

            //맨해튼 거리가 2 이하로 앉으면 안된다.  |r1 - r2| + |c1 - c2| > 2
            //상 하 좌 우 4방향을 탐색한다. --> 만약 O인 지점이 있으면 해당 부분만 큐에 넣은 뒤
            //상 하 좌 우 탐색을 한번만 더 실시한다.

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];


                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visit[nx][ny]) {

                    if ((Math.abs(p.x - nx) + Math.abs(p.y - ny)) > 2) {
                        continue;
                    }

                    if(map[nx][ny].equals("P")){
                        return 0;
                    }

                    if(map[nx][ny].equals("O") ){
                        qu.offer(new Point(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return 1;
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
