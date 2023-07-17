package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노드사이의_거리 {
    static ArrayList<ArrayList<Point>> graph = new ArrayList<>();
    static int n, m;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Point(to, distance));
            graph.get(to).add(new Point(from, distance));
        }

        List<int[]> question = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            question.add(new int[]{firstNode, secondNode});
        }

        getDistance(question);
    }

    private static void getDistance(List<int[]> questions) {
        StringBuilder sb = new StringBuilder();
        for (int[] question : questions) {
            int start = question[0];
            int end = question[1];

            int distance = dfs(start, end);
            sb.append(distance).append('\n');
        }

        print(sb);
    }

    private static void print(StringBuilder sb) {
        System.out.println(sb);
    }

    private static int dfs(int start, int end) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        visit = new boolean[n + 1];
        int[] distance = new int[n + 1];

        while (!qu.isEmpty()) {
            Integer now = qu.poll();

            if (visit[now]) {
                continue;
            }

            for (Point next : graph.get(now)) {
                distance[next.to] = distance[now] + next.distance;
                visit[now] = true;
                qu.offer(next.to);
            }
        }

        return distance[end];
    }

    static class Point{
        int to;
        int distance;

        public Point(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
