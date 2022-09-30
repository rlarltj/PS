package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1309 {
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        //dp[n][2] = n행에 사자를 안놓는 경우의 수
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
        }


        System.out.println(dp[n][0] + dp[n][1] + dp[n][2]);
    }
}


