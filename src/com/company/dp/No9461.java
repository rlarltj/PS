package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9461 {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

//        1, 1, 1, 2, 2, 3, 4, 5, 7, 9 , 12, 16, 21, 28
        dp = new int[101];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append(solve(num)).append('\n');
        }

        System.out.println(sb);
    }

    static int solve(int num) {
        if(num == 0) return dp[0];

        if (dp[num] == 0) {
            dp[num] = solve(num - 1) + solve(num - 5);
        }else{
            return dp[num];
        }

        return dp[num];
    }

}
