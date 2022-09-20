package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11722 {
    static int n;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

//      부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++) {
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
