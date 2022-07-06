package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No6603 {
    static int[] arr;
    static int[] answer;
    static boolean[] isUsed;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            if(a == 0) {
                System.out.println(sb);
                break;
            }

            arr = new int[a];
            for (int i = 0; i < a; i++) {
                arr[i] = Integer.parseInt(st.nextToken(" "));
            }
            Arrays.sort(arr);
            isUsed = new boolean[a];
            answer = new int[6];
            solve(0, a, 0);
            sb.append('\n');
        }


    }

    private static void solve(int depth, int n, int start) {
        if(depth == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(answer[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            if(!isUsed[i]){
                answer[depth] = arr[i];
                isUsed[i] = true;
                solve(depth+1, n, i+1);
                isUsed[i] = false;
            }

        }

    }
}
