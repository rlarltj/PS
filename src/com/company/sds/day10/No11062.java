package com.company.sds.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No11062 {
    static int[][] dp;
    static int[] card;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            card = new int[n];
            dp = new int[n][n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                card[j] = Integer.parseInt(st.nextToken(" "));
            }

            solve(0, n - 1, true);

            System.out.println(dp[0][n-1]);
        }
    }

    private static int solve(int left, int right, boolean flag) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];

        if(flag){
            return dp[left][right] = Math.max(card[left] + solve(left + 1, right, false),
                    card[right] + solve(left, right - 1, false));
        } else {
            return dp[left][right] = Math.min(solve(left + 1, right, true),
                     solve(left, right - 1, true));
        }

    }
}
