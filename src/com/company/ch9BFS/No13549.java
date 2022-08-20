package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13549 {
    static int n, m;
    static int[] map;
    static int count;
    static int[] dx = {1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[100001];

        map[n] = 1;
        bfs(n);

        System.out.println(map[m]-1);
    }

    private static void bfs(int n) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(n);

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0; i < 2; i++) {
                int nx = dx[i] + now;

                if(nx>=0 && nx<100001){
                    if(map[nx] ==0 || map[now] < map[nx]) {
                        qu.offer(nx);
                        map[nx] = map[now] + 1;


                        if (nx == m) break;
                    }
                }
            }

            int nx = now * 2;
            if(nx >= 0 && nx < 100001){
                if(map[nx] ==0 || map[now] < map[nx]){
                    //더 빨리 도착할 수 있으면 갱신한다.
                    qu.offer(nx);
                    map[nx] = map[now];
                    if(nx == m) break;
                }
            }
        }
    }
}
