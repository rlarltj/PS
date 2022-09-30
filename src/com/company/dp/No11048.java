package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11048 {
    static int n, m;
    static int[][] dp;
    static int[][] candy;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        candy = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = candy[0][0];

        for (int i = 1; i < m; i++) {
            dp[0][i] = candy[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = candy[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i-1][j-1], dp[i][j-1])) + candy[i][j];
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
