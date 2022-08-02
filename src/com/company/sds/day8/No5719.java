package com.company.sds.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No5719 {
    static int N, M, S, D;
    static int[] dist;
    static ArrayList[] adj;
    static int answer;

    static boolean[][] isShortest;
    static ArrayList[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            if(N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken(" "));
            M = Integer.parseInt(st.nextToken(" "));

            adj = new ArrayList[N + 1];
            parent = new ArrayList[N + 1];
            isShortest = new boolean[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = new ArrayList<Integer>();
                adj[i] = new ArrayList<Node>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken(" "));
            D = Integer.parseInt(st.nextToken(" "));

            int a, b, c;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken(" "));
                b = Integer.parseInt(st.nextToken(" "));
                c = Integer.parseInt(st.nextToken(" "));

                adj[a].add(new Node(b, c));
            }

            dijkstra(S, D);
        }

    }

    private static void dijkstra(int start, int dest) {
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> qu = new PriorityQueue<>();
        dist[start] = 0;
        qu.offer(new Node(start, 0));

        while (!qu.isEmpty()) {
            Node now = qu.poll();

            if(now.cost > dist[now.id]) continue;

            int len = adj[now.id].size();

            for (int i = 0; i < len; i++) {
                Node next = (Node) adj[now.id].get(i);

                if(isShortest[now.id][next.id]) continue;

                if (dist[next.id] == now.cost + next.cost) {
                    parent[next.id].add(now.id);
                }

            }
        }
    }

    static class Node implements Comparator<Node> {
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }
}
