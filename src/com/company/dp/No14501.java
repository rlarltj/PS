package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14501 {
    static int n;
    static int[] dp;
    static int[] time;
    static int[] pay;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];
        pay = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];

        solve(1);

        System.out.println(dp[1]);
    }

    private static int solve(int day) {
        if(day > n+1) return Integer.MIN_VALUE;

        if(day == n+1) return 0;

        if(dp[day] == 0){
            dp[day] = Math.max(solve(day+1), solve(day+time[day]) + pay[day]);
        }else{
            return dp[day];
        }

        return dp[day];
    }
}
