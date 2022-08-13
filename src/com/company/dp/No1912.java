package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1912 {
    static int n;
    static int[] nums;
    static int max = -100_000_000;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solve(n);
        System.out.println(max);
    }

    static int solve(int n) {
        if(n == 0) return 0;

        if (dp[n] == null) {
            dp[n] = Math.max(nums[n], solve(n-1) + nums[n]);
            max = Math.max(max, dp[n]);
        }else{
            return dp[n];
        }

        return dp[n];
    }
}
