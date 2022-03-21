package com.company.ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2493V2 {
    public static void main(String[] args) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer sk = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        int[] arr2 = new int[num];

        for(int i =0; i<num; i++){
            arr[i] = (Integer.parseInt(sk.nextToken(" ")));
        }


        for(int i = arr.length-1; i>=1; i--){
            for(int j = arr.length-2; j>=0; j--){
                if(arr[i]< arr[j])
                    arr2[i] = j+1;
                else continue;
            }
        }
        arr2[0] = 0;

        for(int i =0; i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        }
    }
}
