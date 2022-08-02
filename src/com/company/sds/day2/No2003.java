package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));
        st = new StringTokenizer(br.readLine());

        int[] arr= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }


        int low = 0;
        int high = 0;
        int count = 0;

        while(high < n){
        int sum = 0;
            for (int i = low; i <= high; i++) {
                sum += arr[i];
            }

            if(sum < m){
                high++;
            }else if(sum > m){
                low++;
            }else{
                count++;
                low++;
            }
        }

        System.out.println(count);

    }
}
