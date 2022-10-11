package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5557 {
    static int n;
    static int[] nums;
    static long[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

//        dp[i][j] = i번째 수 까지의 합이 j인 경우의 수
        dp = new long[n][21];
        dp[0][nums[0]] = 1;

        int plus;
        int minus;

        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j <= 20; j++) {
                plus = j + nums[i];
                minus = j - nums[i];

                if (plus >= 0 && plus <= 20) {
                    dp[i][plus] += dp[i - 1][j];
                }

                if (minus >= 0 && minus <= 20) {
                    dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 2][nums[n - 1]]);
    }
}
