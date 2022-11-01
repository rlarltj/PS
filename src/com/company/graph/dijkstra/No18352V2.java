package com.company.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No18352V2 {
    static int N, M, K, X;
    static boolean[] visit;
    static List<Integer>[] list;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static int INF = 100_000_000;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        dist = new int[N + 1];
        answer = new LinkedList<>();
        list = new ArrayList[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            list[a].add(b);
            list[b].add(a);
        }

        bfs(X);

        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    private static void bfs(int n) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(n);

        visit[n] = true;
        dist[n] = 0;

        while (!qu.isEmpty()) {
            int p = qu.poll();

            for (int next : list[p]) {
                if(dist[next] == INF){
                    qu.offer(next);
                    dist[next] = dist[p] + 1;
                }
            }
        }
    }
}
