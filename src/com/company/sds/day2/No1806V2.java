package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806V2 {
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        int start = 0;
        int end = 0;
        int sum = arr[0];

        while (true) {

            if (sum > m) {
                MIN = Math.min(end-start+1, MIN);
                sum -= arr[start++];
            } else if (sum < m) {
                sum += arr[++end];
            } else {
                MIN = Math.min(end-start+1, MIN);
                sum += arr[++end];
            }

            if (end == n) {
                if(MIN == Integer.MAX_VALUE) System.out.println(0);
                else{
                    System.out.println(MIN);
                }
                break;
            }
        }

    }
}
