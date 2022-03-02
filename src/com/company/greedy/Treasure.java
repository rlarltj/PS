package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[num];
        int[] brr = new int[num];
        int sum = 0;

            st = new StringTokenizer(br.readLine());
        for(int i= 0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
            st = new StringTokenizer(br.readLine());
        for(int i= 0; i<num; i++){
            brr[i] = Integer.parseInt(st.nextToken(" "));
        }
        int[] crr = brr.clone();
        Arrays.sort(crr);
        Arrays.sort(arr, Collections.reverseOrder());


        for(int i =0; i<num; i++){
            sum+= arr[i]*crr[i];
        }
        System.out.println(sum);


    }
}
