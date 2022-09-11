package com.company.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1238 {
    static int N, M, X;
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] list2;
    static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        list2 = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
            list2[i] = new ArrayList();
        }

        int start, dest, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(dest, cost));
            list2[dest].add(new Node(start, cost));
        }

        int[] dist1 = dijks(X, list);


        int[] dist2 = dijks(X, list2);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dist1[i]+dist2[i], max);
        }

        System.out.println(max);
    }

    private static int[] dijks(int start, ArrayList<Node>[] lists) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> qu = new PriorityQueue<>();
        qu.offer(new Node(start, 0));
        dist[start] = 0;

        while (!qu.isEmpty()) {
            Node now = qu.poll();
            int cur = now.dest;

            int size = lists[cur].size();
            for (int i = 0; i < size; i++) {
                Node n = lists[cur].get(i);

                if(dist[n.dest] > dist[cur] + n.cost){
                    dist[n.dest] = dist[cur] + n.cost;

                    qu.offer(new Node(n.dest, dist[n.dest]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}
