package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1003 {
    static int t, n;

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            solve(n);
            System.out.println(dp[n][0]+" "+dp[n][1]);
        }

    }

    private static Integer[] solve(int n) {

        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = solve(n-1)[0] + solve(n-2)[0];
            dp[n][1] = solve(n-1)[1] + solve(n-2)[1];
        }
        else{
            return dp[n];
        }

        return dp[n];
    }

}
