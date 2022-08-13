package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1149 {
    static int N;
    static int[][] cost;
    static int[][] dp;

    static int RED = 0;
    static int BLUE = 1;
    static int GREEN = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        dp = new int[N][3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(solve(N - 1, RED), Math.min(solve(N - 1 , GREEN), solve(N - 1, BLUE))));
    }

    static int solve(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == RED) {
                dp[n][RED] = Math.min(solve(n - 1, GREEN), solve(n - 1, BLUE)) + cost[n][RED];
            }
            else if (color == GREEN) {
                dp[n][GREEN] = Math.min(solve(n - 1, RED), solve(n - 1, BLUE)) + cost[n][GREEN];
            }
            else if (color == BLUE) {
                dp[n][BLUE] = Math.min(solve(n - 1, GREEN), solve(n - 1, RED)) + cost[n][BLUE];
            }
        }
        else{
            return dp[n][color];
        }


        return dp[n][color];
    }
}
