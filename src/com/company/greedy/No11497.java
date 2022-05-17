package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11497 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken(" "));
            }
            Arrays.sort(arr);

            int[] answer = new int[n];

            int l = 0;
            int r = n-1;

            for (int j = 0; j < n; j++) {
                if(j%2 == 0){       // 2 5 9 7 4
                    answer[l++] = arr[j];
                }else{
                    answer[r--] = arr[j];
                }
            }

            int max = 0;
            for (int j = 0; j < n-1; j++) {
                max = Math.max(max, Math.abs(answer[j] - answer[j+1]));
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}
