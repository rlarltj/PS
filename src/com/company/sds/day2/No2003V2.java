package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003V2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));
        st = new StringTokenizer(br.readLine());

        int[] arr= new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }


        int low = 0;
        int high = 0;
        int count = 0;
        int sum = arr[0];
        while(true) {
            if(sum == m){
                count++;
                sum -= arr[low++];
            }else if(sum > m){
                sum -= arr[low++];
            }else{
                sum += arr[++high];
            }

            if(high == n) break;
        }
        System.out.println(count);

    }
}
