package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15657 {
    static int n, size;
    static int[] arr;
    static int[] ans;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        size = Integer.parseInt(st.nextToken(" "));
        arr = new int[n];
        ans = new int[size];
        sb = new StringBuffer();
        Arrays.sort(arr);
        solve(0, 0);

        System.out.println(sb);
    }

    private static void solve(int depth, int start) {
        if(depth == n){
            for (int i = 0; i < size; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            ans[depth] = arr[start];
            solve(depth+1, start+1);
        }
    }
}
