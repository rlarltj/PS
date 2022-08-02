package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11404 {
    static final int INF = 500_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) dp[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken(" "));
            int dest = Integer.parseInt(st.nextToken(" "));
            int time = Integer.parseInt(st.nextToken(" "));

            dp[start][dest] = Math.min(time, dp[start][dest]);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dp[i][j] == INF) dp[i][j] = 0;
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
