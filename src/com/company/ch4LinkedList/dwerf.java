package com.company.ch4LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dwerf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int find = sum - 100;  // 두마리의 무게가 find와 동일하면 난쟁이 검거
        int a = 0;
        int b = 0;

         Loop1: for(int i =0; i<8; i++){
            for(int j = i+1; j<9; j++){
                if(arr[i] + arr[j] == find){
                  a = i;
                  b = j;
                  break Loop1;
                }
            }
        }
        arr[a] = 100;
        arr[b] = 100;
        Arrays.sort(arr);

        for(int i =0; i<7; i++)
            System.out.println(arr[i]);
    }
}
