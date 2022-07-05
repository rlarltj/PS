package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15663 {
    static int[] arr;
    static int[] answer;
    static boolean[] isUsed;
    static int n, m;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        arr = new int[n];
        answer = new int[m];
        isUsed = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        Arrays.sort(arr);
        solve(0);
        System.out.println(sb);
    }

    private static void solve(int depth) {

        if (depth == m) {

            for (int i = 0; i < depth   ; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append('\n');
            return;
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i];

            if(isUsed[i] || tmp == now){
                //이전에 뽑은 값과 현재 뽑은 now와 같다면, 중복된 수열이다.
                continue;
            }else{
                //중복 수열이 아닌 경우
                tmp = now;
                isUsed[i] = true;
                answer[depth] = arr[i];
                solve(depth+1);
                isUsed[i] = false;
            }
        }
    }
}
