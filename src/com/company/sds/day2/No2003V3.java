package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003V3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        int start = 0;
        int end = 0;
        int sum = arr[0];
        int count = 0;

        while (true) {
            if (sum < m) {
                sum += arr[++end];
            } else if (sum > m) {
                sum -= arr[start++];
            } else {
                //둘이 같은 경우
                count ++;
                sum -= arr[start++];
            }

            //탈출 조건
            if (end == n) {
                break;
            }
        }

        System.out.println(count);
    }
}
