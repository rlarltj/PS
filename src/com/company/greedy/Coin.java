package com.company.greedy;

import java.io.*;


public class Coin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int num = Integer.parseInt(st[0]);
        int value = Integer.parseInt(st[1]);
        int count = 0;

        int[] arr = new int[num];
        for(int i =0; i<num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = num-1; i>0; i--){
            if(arr[i]<= value){
                int q = value/arr[i];
                count+= q;
                value = value % arr[i];
            }
        }
        System.out.print(count);
    }
}