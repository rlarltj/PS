package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806 {
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        int low = 0;
        int high = 0;
        int sum = arr[0];

        while(low<=n && high <= n){
            if(sum > m){
                MIN = Math.min(high-low, MIN);
                sum -= arr[low++];
            } else if (sum < m) {
                sum += arr[++high];
            } else {
                MIN = Math.min(high - low, MIN);
                sum += arr[++high];
            }

            if(high == n){
                if(MIN == Integer.MAX_VALUE) System.out.println(0);
                else{
                    System.out.println(MIN);
                }
                break;
            }
        }

    }
}
