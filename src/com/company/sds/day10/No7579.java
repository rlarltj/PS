package com.company.sds.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7579 {
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] cost = new int[n];
        int[] dp = new int[10001];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(""));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken(""));
        }


    }
}
