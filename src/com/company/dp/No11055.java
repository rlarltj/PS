package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11055 {
    static int n;
    static int[] dp;

    static int[] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n + 1];
        dp = new int[n + 1];
        int answer = 0;
        for (int i = 1; i <=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + nums[i]) {
                    dp[i] = dp[j] + nums[i];
                }
            }

            if(answer < dp[i]) answer = dp[i];
        }
        System.out.println(answer);
    }
}
