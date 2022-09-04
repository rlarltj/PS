package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1463 {
    static int n;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        int result = solve(n);
        System.out.println(result);
    }

    static int solve(int n) {

        if (dp[n] == null) {
            if (n % 3 == 0 && n % 2 == 0) {
                dp[n] = Math.min(solve(n / 3), Math.min(solve(n / 2), solve(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(solve(n / 3), solve(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(solve(n / 2), solve(n - 1)) + 1;
            } else {
                dp[n] = solve(n - 1) + 1;
            }
        }

        return dp[n];
    }
}
