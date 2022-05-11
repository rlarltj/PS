package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class No1417 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int d = Integer.parseInt(br.readLine());  // 다솜의 득표 수
        if(num == 1){
            System.out.println(0);
            return;
        }
        Integer[] arr = new Integer[num-1];
        for (int i = 0; i < num-1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;

//        if(num == 1)
        while(true){
            Arrays.sort(arr, Collections.reverseOrder());

            if(d > arr[0]) break;
            arr[0]--;
            d++;
            count++;
        }

        System.out.println(count);


    }
}
