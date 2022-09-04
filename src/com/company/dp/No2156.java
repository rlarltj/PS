package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2156 {
    static int n;
    static Integer[] dp;
    static int[] glass;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        glass = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = glass[1];

        if (n > 1) {
            dp[2] = glass[1] + glass[2];
        }
        
        int result = recur(n);
        System.out.println(result);
    }

    static int recur(int N) {

        if(dp[N] == null) {
            dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + glass[N - 1]) + glass[N], recur(N - 1));
        }

        return dp[N];
    }
}
