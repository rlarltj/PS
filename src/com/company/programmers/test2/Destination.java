package com.company.programmers.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Destination {
    static final int INF = 100_000_000;
    static int[] dist;
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};


        solution(5, arr, new int[]{1,3,5}, 5);
    }

    static int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] result = new int[n+1];
        int[] answer = new int[sources.length];
        dist = new int[n + 1];

        ArrayList<Node>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);

        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];

            list[a].add(new Node(b, 1));
            list[b].add(new Node(a, 1));
        }

        PriorityQueue<Node> qu = new PriorityQueue<>();

        qu.offer(new Node(destination, 0));
        dist[destination] = 0;

        while (!qu.isEmpty()) {
            Node node = qu.poll();

            int cur = node.dest;

            for(Node next : list[cur]) {
                if (dist[next.dest] > dist[node.dest] + 1) {
                    dist[next.dest] = dist[node.dest] + 1;
                    qu.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                result[i-1] = -1;
            }

            else{
                result[i-1] = dist[i];
            }
        }
        for (int i = 0; i < sources.length; i++) {
            int idx = sources[i];
            answer[i] = result[idx-1];

        }

        return answer;
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
