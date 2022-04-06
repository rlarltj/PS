package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DongjoonGame {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 5   0
         * 5   1
         * 5   2
         */
        int count = 0;
        int cursor = num-1;
        for (int i = num-1; i>0; i--) {
            if(arr[cursor]<= arr[i-1]){
                count += arr[i-1]-arr[cursor]+1;
                arr[i-1]  = arr[cursor]-1;
                cursor = i-1;
            }else{
                cursor = i-1;
            }

        }
        System.out.println(count);
    }
}
