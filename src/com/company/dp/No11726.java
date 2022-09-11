package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        if (N == 1) {
            System.out.println(1);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;

        dp[2] = 2;

        System.out.println(solve(N));
    }

    private static int solve(int n) {

        if (dp[n] == 0) {
            dp[n] = (solve(n - 1) + solve(n - 2)) % 10007;
        } else {
            return dp[n] % 10007;
        }

        return dp[n] % 10007;
    }
}
