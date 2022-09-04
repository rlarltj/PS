package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2631 {
    static int n;
    static int[] dp;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if(max < dp[i]) max = dp[i];
        }

        System.out.println(n - max);
    }
}
