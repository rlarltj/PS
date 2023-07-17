package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 너비_우선_탐색_1 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(i, new ArrayList<>());
        }
        //양방향 간선
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        bfs(n, m, start);
    }

    private static void bfs(int n, int m, int start) {
        boolean[] visit = new boolean[n + 1];

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        int idx = 1;

        while (!qu.isEmpty()) {

            Integer now = qu.poll();

            if (visit[now]) {
                continue;
            }

            answer[now] = idx++;
            visit[now] = true;

            for (int next : list.get(now)) {
                qu.offer(next);
            }

        }

        print(n);
    }

    private static void print(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
    }


}
