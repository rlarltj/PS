package com.company.ch3배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3273 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        int sum = Integer.parseInt(br.readLine());
        int[] arr2 = new int[sum];
        for(int i =0; i<num; i++){
            if(arr[i]<sum)
            arr2[arr[i]]++;
        }

        for(int i = 0; i<sum; i++){
            if(arr2[i] == 1 && arr2[sum-i] == 1){
                count++;
            }
        }

        System.out.println(count/2);
        }
}
