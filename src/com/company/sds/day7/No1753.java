package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1753 {
    static int n, m, start;
    static ArrayList<Node>[] list;
    static int[] dist;
    static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        start = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);
        int a, b, time;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken(" "));
            b = Integer.parseInt(st.nextToken(" "));
            time = Integer.parseInt(st.nextToken(" "));

            list[a].add(new Node(b, time));
        }

        StringBuilder sb = new StringBuilder();

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if(dist[i] == INF) sb.append("INF"+"\n");
            else sb.append(dist[i]+"\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> qu = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];

        //출발지를 큐에 넣고 비용은 0
        qu.add(new Node(start, 0));
        dist[start] = 0;

        while (!qu.isEmpty()) {
            Node curNode = qu.poll();
            int cur = curNode.dest;
            if(visit[cur]) continue;

            for(Node node : list[cur]){
                if (dist[node.dest] > dist[cur] + node.time) {
                    dist[node.dest] = dist[cur] + node.time;
                    qu.offer(new Node(node.dest, dist[node.dest]));

                }

            }
        }

    }

    static class Node implements Comparable<Node> {
        int dest;
        int time;

        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}
