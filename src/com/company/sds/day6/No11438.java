package com.company.sds.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11438 {
    static int N, m;
    static int[][] dp;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[18][N + 1];
        depth = new int[N + 1];
        int[] visit = new int[N + 1];

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a,b;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken(" "));
            b = Integer.parseInt(st.nextToken(" "));

            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        visit[1] = 1;

        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int i = 0; i < adj[curr].size(); i++) {
                int next = adj[curr].get(i);

                if (visit[next] == 1) {
                    continue;
                }
                dp[0][next] = curr;
                visit[next] = 1;
                depth[next] = depth[curr] +1;
                qu.add(next);
            }
        }

        for (int i = 1; i <= 17; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
                //dp[1][1] = dp[0][dp[0][1]];
                //parent[k][v] = parent[k-1][parent[k-1][v]]
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken(" "));
            b = Integer.parseInt(st.nextToken(" "));
            sb.append(lca(a, b) + "\n");
        }

        System.out.println(sb);
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        int gap = depth[b] - depth[a];
        for (int i = 0; i <= 17; i++) {
            if ((gap & (1 << i)) > 0) {
                b = dp[i][b];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = 17; i >= 0; i--) {
            if (dp[i][a] != dp[i][b]) {
                a = dp[i][a];
                b = dp[i][b];

            }
        }
        return dp[0][a];
    }
}