package com.company.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No14938 {
    static int n, m, r;
    static int[] items;
    static ArrayList<Point>[] list;
    static int answer;
    static int[] dist;
    static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());


        items = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int from, to, cost;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            list[from].add(new Point(to, cost));
            list[to].add(new Point(from, cost));
        }
        for (int i = 1; i <= n; i++) {
            int itemNum = 0;
            dijks(i);

            for (int j = 1; j <= n; j++) {
                if (dist[j] <= m) {
                    itemNum += items[j];
                }
            }

            answer = Math.max(itemNum, answer);
        }

        System.out.println(answer);
    }

    private static void dijks(int start) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Point> qu = new PriorityQueue<>();
        qu.offer(new Point(start, 0));
        dist[start] = 0;

        while (!qu.isEmpty()) {
            Point cur = qu.poll();
            int size = list[cur.to].size();

            for (int i = 0; i < size; i++) {
                Point next = list[cur.to].get(i);

                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;

                    qu.offer(new Point(next.to, dist[next.to]));
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int to;
        int cost;

        public Point(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point point) {
            return this.cost - point.cost;
        }
    }
}
