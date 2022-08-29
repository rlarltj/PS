package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9465 {
    static int n;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            dp = new int[2][n + 1];
            for (int k = 0; k < 2; k++) {
                st = new StringTokenizer(br.readLine());
                for (int r = 1; r <= n; r++) {
                    arr[k][r] = Integer.parseInt(st.nextToken());
                }
            }
            int result = solve(n);
            System.out.println(result);
        }
    }

    private static int solve(int n) {
        dp[0][0] = dp[1][0] = 0;
        dp[1][1] = arr[1][1];
        dp[0][1] = arr[0][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
        }

        return Math.max(dp[0][n], dp[1][n]);
    }
}
