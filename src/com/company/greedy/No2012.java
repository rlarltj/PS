package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);   // 1 1 2 3 5
        long sum = 0;
        for (int i = 0; i < num; i++) {
            sum += (Math.max(arr[i], i+1) - Math.min(arr[i],i+1));
        }

        System.out.println(sum);


    }
}
