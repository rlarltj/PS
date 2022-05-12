package com.company.greedy;

import java.io.IOException;
import java.util.*;

public class No7570 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] dp = new int[n+1];

        for(int i=0; i<n; i++) {
            int k = scan.nextInt();
            dp[k] = dp[k-1]+1;
        }

        Arrays.sort(dp);
        System.out.println(n-dp[n]);
    }
}