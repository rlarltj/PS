package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        int count = 0;

        // 0 --> 1 --> 2 --> 0 --> 1 --> 2

        int milk = 0;

        for (int i = 0; i < num; i++) {
            if(arr[i] == milk){
                count ++;
                milk++;

                if(milk == 3) milk = 0;
            }
        }

        System.out.println(count);

    }
}
