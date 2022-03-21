package com.company.ch3배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1475 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        StringBuffer sb = new StringBuffer();
        int[] count = new int[10];
        for(int i= 0; i< arr.length; i++){
            count[Integer.parseInt(arr[i])]++;
        }

        count[6] += count[9];
        count[9] = 0;
        if(count[6] % 2 == 1 ){
            count[6] = count[6]/2 +1;
        }else{
            count[6] /= 2;
        }

        Arrays.sort(count);
        System.out.println(count[9]);

    }
}
