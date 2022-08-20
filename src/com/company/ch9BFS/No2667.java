package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2667 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][num];
        boolean[][] visit = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < num; j++) {
                arr[i][j]= Integer.parseInt(s[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int count = 0;
        int sum = 0;
        Queue<Point> qu = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(arr[i][j] == 1 && !visit[i][j]){
                    qu.offer(new Point(i,j));
                    visit[i][j] = true;
                    count++;
                    sum = 1;

                    while(!qu.isEmpty()){
                        Point p = qu.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = p.x +dx[k];
                            int ny = p.y +dy[k];

                            if(nx<0 || nx>=num || ny<0 || ny>=num){
                                continue;
                            }
                            if(arr[nx][ny]==1 && !visit[nx][ny]){
                                qu.offer(new Point(nx,ny));
                                visit[nx][ny]= true;
                                sum++;
                            }
                        }
                    }
                list.add(sum);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        list.stream().forEach(integer->{
            System.out.println(integer);
        });
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
