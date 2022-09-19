package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11057 {
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1001][10];

        for (int i = 0; i < 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i < 1001; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
            }
        }
        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % 10007);
    }
}
