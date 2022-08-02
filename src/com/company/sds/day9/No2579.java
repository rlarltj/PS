package com.company.sds.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579 {
    static int num;
    static int[] step;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        //계단의 값
        step = new int[num + 1];
        //i까지 구한 최댓값
        dp = new int[num + 1];

        for (int i = 0; i < num; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        find(0);

    }

    private static int find(int depth) {
        int sum = 0;
        if (depth == num) {
            return dp[num];
        }

        if (dp[depth] == 0) {
            dp[depth] = find(depth+1);
        }
        return sum;
    }
}
