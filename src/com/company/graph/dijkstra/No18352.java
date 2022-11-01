package com.company.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No18352 {
    static final int INF = 100_000_000;
    static int N, M, K, X;
    static ArrayList<Node>[] list;
    static int[] dist;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            //양방향 간선
            list[a].add(new Node(b, 1));
            list[b].add(new Node(a, 1));
        }

        dijks(X);

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    private static void dijks(int start) {
        PriorityQueue<Node> qu = new PriorityQueue();
        qu.offer(new Node(start, 0));
        dist[start] = 0;

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            int cur = node.dest;
            int size = list[cur].size();
            int cost = node.cost;
            if (dist[cur] < cost) {
                continue;
            }

            for (int i = 0; i < size; i++) {
                Node n = list[cur].get(i);

                if (dist[n.dest] > dist[cur] + n.cost) {
                    dist[n.dest] = dist[cur] + n.cost;

                    qu.offer(new Node(n.dest, dist[n.dest]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
