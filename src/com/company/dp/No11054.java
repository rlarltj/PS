package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11054 {
    static int n;
    static int[] dp;
    static int[] dp2;
    static int[] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        dp2 = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);

        // 가장 긴 오름차순을 구한다.
        int d1 = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            d1 = Math.max(d1, dp[i]);
        }

        int d2 = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
            d2 = Math.max(d2, dp2[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] += dp2[i];
            max = Math.max(dp[i], max);
        }

        System.out.println(max -1);
    }
}
