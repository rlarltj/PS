package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11727 {
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];


        System.out.println(solve(n));
    }

    static long solve(int n) {
        dp[0] = 1;
        dp[1] = 1;

        if (dp[n] == 0) {
            dp[n] = (solve(n - 1) + solve(n - 2) * 2) % 10007;
        }else {
            return dp[n];
        }

        return dp[n];
    }
}
