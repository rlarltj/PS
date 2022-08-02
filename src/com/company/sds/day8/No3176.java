package com.company.sds.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3176 {
    static int n, k;
    static int[][] dp;
    static int[] depth;
    static ArrayList<Node>[] adj;
    static int[][] minCost;
    static int[][] maxCost;

    static int min, max;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[18][n + 1];
        depth = new int[n + 1];
        adj = new ArrayList[n + 1];

        minCost = new int[18][n + 1];
        maxCost = new int[18][n + 1];

        int[] visit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b, cost;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken(" "));
            b = Integer.parseInt(st.nextToken(" "));
            cost = Integer.parseInt(st.nextToken(" "));

            adj[a].add(new Node(a, b, cost));
            adj[b].add(new Node(b, a, cost));
        }

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1);
        visit[1] = 1;

        //depth 찾기
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int i = 0; i < adj[curr].size(); i++) {
                Node next= adj[curr].get(i);
                int start = next.dest;

                if(visit[start] == 1){
                    continue;
                }

                dp[0][start] = curr;
                visit[start] = 1;
                depth[start] = depth[curr] + 1;
                qu.add(start);

                minCost[0][start] = next.cost;
                maxCost[0][start] = next.cost;

            }
        }
        //부모 채우기
        for (int i = 1; i <= 17; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];

                minCost[i][j] = Math.min( minCost[i-1][j], minCost[i-1][dp[i-1][j]]);
                maxCost[i][j] = Math.max( maxCost[i-1][j], maxCost[i-1][dp[i-1][j]]);
            }
        }
        min = 100_000_000;
        max = -1;
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken(" "));
            b = Integer.parseInt(st.nextToken(" "));
            int lca = lca(a, b);

//            getLength(lca, a, b);

            System.out.println(min+" "+max);
        }
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        int gap = depth[b] - depth[a];
        //depth 맞추기
        for (int i = 0; i <= 17; i++) {
            if ((gap & (1 << i)) > 0) {
                min = Math.min(min, minCost[i][a]);
                max = Math.max(max, maxCost[i][a]);
                b = dp[i][b];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = 17; i >= 0; i--) {
            if (dp[i][a] != dp[i][b]) {

                min = Math.min(min, Math.min(minCost[i][a], minCost[i][b]));
                max = Math.max(max, Math.max(maxCost[i][a], maxCost[i][b]));
                a = dp[i][a];
                b = dp[i][b];

            }
        }
        min = Math.min(min, Math.min(minCost[0][a], minCost[0][b]));
        max = Math.max(max, Math.max(maxCost[0][a], maxCost[0][b]));
        return dp[0][a];
    }

    static class Node{
        int start;
        int dest;
        int cost;

        public Node(int start, int dest, int cost) {
            this.start = start;
            this.dest = dest;
            this.cost = cost;
        }
    }
}
