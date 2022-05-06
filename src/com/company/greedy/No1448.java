package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class No1448 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for (int i = 0; i < num-2; i++) {
            int big = arr[i];
            int a = arr[i+1];
            int b = arr[i+2];

            if(big >= a+b) continue;

            System.out.println(a+b+big);
            return;
        }
        System.out.println(-1);
    }
}
