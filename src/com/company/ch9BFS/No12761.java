package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No12761 {
    static int a, b, n, m;
    static int[] arr;
    static Queue<Point> qu;
    static boolean[] visit;
    static int[] dx = {1, -1, a, -a, b, -b};
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken(" "));
        b = Integer.parseInt(st.nextToken(" "));
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        count = 0;
        qu = new LinkedList<>();
        arr = new int[100001];
        visit = new boolean[100001];
        /**
         * 좌 우로 한 칸 이동 가능
         * 좌 우로 a,b 만큼 이동 가능
         * 우로 현재 위치 * (a || b) 배 만큼 이동 가능
         */

        bfs();
        System.out.println(count);
    }

    private static void bfs() {
        qu.offer(new Point(n, 0));
        visit[n] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            if(p.x == m){
                count = p.y;
                return;
            }
            if(p.x + 1 < 100001 && !visit[p.x+1]){
                visit[p.x+1] = true;
                qu.offer(new Point(p.x+1, p.y+1));
            }
            if(p.x - 1 >=0 && !visit[p.x-1]) {
                visit[p.x-1] = true;
                qu.offer(new Point(p.x-1, p.y+1));
            }
            if(p.x + a <100001 && !visit[p.x+a]) {
                visit[p.x+a] = true;
                qu.offer(new Point(p.x+a, p.y+1));
            }
            if(p.x - a >=0 && !visit[p.x-a]) {
                visit[p.x-a] = true;
                qu.offer(new Point(p.x-a, p.y+1));
            }

            if(p.x + b < 100001 && !visit[p.x+b]){
                visit[p.x+b] = true;
                qu.offer(new Point(p.x+b, p.y+1));
            }
            if(p.x - b >=0 && !visit[p.x-b]) {
                visit[p.x-b] = true;
                qu.offer(new Point(p.x-b, p.y+1));
            }

            if(p.x * a < 100001 && !visit[p.x*a]){
                visit[p.x*a] = true;
                qu.offer(new Point(p.x * a, p.y+1));
            }
            if(p.x * b < 100001 && !visit[p.x*b]){
                visit[p.x*b] = true;
                qu.offer(new Point(p.x * b, p.y+1));
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
