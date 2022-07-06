package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15666 {
    static int n, m;
    static int[] arr;
    static int[] answer;
//    static boolean[] isUsed;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        arr = new int[n];
        answer = new int[m];
//        isUsed = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr);

        solve(0, 0);
        System.out.println(sb);
    }

    private static void solve(int depth, int start) {
        if(depth == m){
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]+" ");
            }
            sb.append('\n');
            return;
        }
        int prev = 0;
        for (int i = start; i < n; i++) {
            answer[depth] = arr[i];

            int now = arr[i];
            if(now == prev){
                continue;
            }else{
                prev = now;
                solve(depth+1, i);
            }
        }
    }
}
