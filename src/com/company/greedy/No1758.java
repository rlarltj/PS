package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No1758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tip = 0;


        Arrays.sort(arr, Comparator.reverseOrder());
        // 내림차순으로 정렬

        for(int i =0; i<=num-1; i++){
            arr[i] = arr[i] - i;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0)
            tip += arr[i];
        }
        System.out.println(tip);

    }
}
