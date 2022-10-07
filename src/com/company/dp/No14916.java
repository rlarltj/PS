package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14916 {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        if (n < 4) {
            System.out.println(dp[n]);
            return;
        }
        for (int i  = 4; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = i / 5;
            }else {
                dp[i] = dp[i - 2] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
