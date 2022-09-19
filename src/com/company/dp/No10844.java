package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10844 {
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[101][10];
        // 길이가 i 일때, j로 끝나는 경우의 수
        //   0  1  2  3  4  5  6  7  8  9
        //1  0  1  1  1  1  1  1  1  1  1
        //2  1  1  2  2  2  2  2  2  2  1
        //3  1  3  3  4  4  4  4  4  3  2
        //4  2  4  6  7  8  8  8  7  6  3

        dp[1][0] = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % 1000000000);
    }
}
