package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {
    static int n;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            dp = new int[12];

            solve(a);
            System.out.println(dp[a]);
        }
    }

    private static int solve(int a) {
        // 1 또는 2 또는 3을 더해서 a가 되는 경우의 수를 구한다.
        // Math.max(a-1이 되는 경우의 수 + 1, a-2가 되는 경우의 수 + 2, a-3이 되는 경우의 수 + 4)
        if(a<=0) return 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        // dp[4] = dp[1] + 3,  dp[2] + 2,  dp[3] + 1  ==> 4, 4, 5  중 5
        if (dp[a] == 0) {
            dp[a] = solve(a - 3) + solve(a - 1) + solve(a - 2);
        }else{
            return dp[a];
        }

        return dp[a];
    }
}
