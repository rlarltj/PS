package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1926V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];


        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        int area = 0;
        int max = 0;
        int count = 0;

        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, -1 , 0, 1};

        Queue<Point> qu = new LinkedList<>();

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(arr[i][j] == 0 || visit[i][j]){
                    continue;
                }

                area = 0;
                count++;


                qu.offer(new Point(i, j));
                visit[i][j] = true;

                while(!qu.isEmpty()){
                    Point p = qu.poll();
                    area++;

                    for(int k = 0; k< 4 ; k++){
                        int nx = p.x+dx[k];
                        int ny = p.y+dy[k];



                    if(nx <0 || nx>= n || ny<0 || ny>=m){
                        continue;
                    }

                    if(arr[nx][ny] == 1 && !visit[nx][ny]){
                        qu.offer(new Point(nx, ny));
                        visit[nx][ny] = true;
                    }

                    }



                }



            }
            if(area>max){
                max = area;
            }

        }


        System.out.println(count);
        System.out.println(max);






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
