package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire {
public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken(" "));
    int m = Integer.parseInt(st.nextToken(" "));

    String[][] map = new String[n][m];
    Queue<Point> fq = new LinkedList<>();
    Queue<Point> jq = new LinkedList<>();
    int[][] dist1 = new int[n][m];
    int[][] dist2 = new int[n][m];

    int[] dx = {1, 0 , -1, 0};
    int[] dy = {0, 1 , 0, -1};
    for(int i =0; i< n ; i++){
        String[] input = br.readLine().split("");
        for (int j = 0; j < m; j++) {
            map[i][j] = input[j];

            if(map[i][j].equals("J")){
                dist2[i][j] = 1;
                jq.offer(new Point(i,j));
            }else if(map[i][j].equals("F")){
                dist1[i][j] = 1;
                fq.offer(new Point(i,j));
            }else if(map[i][j].equals(".")){
                dist1[i][j] = -1;
                dist2[i][j] = -1;
            }
        }
    }

    // 불 BFS
    while(!fq.isEmpty()){
        Point p = fq.poll();

        for (int i = 0; i < 4; i++) {
            int nx = p.x+dx[i];
            int ny = p.y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>= m) continue;


            if(map[nx][ny].equals("#")) continue;

            if(dist1[nx][ny] >= 1) continue;

            dist1[nx][ny] = dist1[p.x][p.y]+1;
            fq.offer(new Point(nx, ny));
        }
    }

    //지훈 BFS
    while(!jq.isEmpty()){
        Point p = jq.poll();

        for (int i = 0; i < 4; i++) {
            int nx = p.x+dx[i];
            int ny = p.y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>= m) {
                System.out.println(dist2[p.x][p.y]);
                return;
            }


            if(map[nx][ny].equals("#")) continue;

            if(dist2[nx][ny] >= 1) continue;
            //불이 지나간 자리이고, 불의 거리보다 지훈이 거리가 크거나 같으면 패스한다.
            if(dist1[nx][ny] != -1 && dist2[p.x][p.y] +1 >= dist1[nx][ny])
                continue;
            dist2[nx][ny] = dist2[p.x][p.y]+1;
            jq.offer(new Point(nx, ny));
        }
    }
    System.out.println("IMPOSSIBLE");

}
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
