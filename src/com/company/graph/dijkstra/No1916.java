package com.company.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1916 {
    static int N, M;
    static ArrayList<Node>[] list;
    static final int INF = 100_000_000;
    static int[] dist;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
        }

        StringTokenizer st;
        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }



        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        dijks(start, dest);
        System.out.println(dist[dest]);
    }

    private static void dijks(int start, int d) {
        PriorityQueue<Node> qu = new PriorityQueue<>();
        qu.offer(new Node(start, 0));
        dist[start] = 0;

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            int cur = node.dest;

            if(check[cur]){
                continue;
            }

            check[node.dest] = true;

            for(Node n : list[cur]){

                if(dist[n.dest] > dist[cur] + n.cost){
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
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
