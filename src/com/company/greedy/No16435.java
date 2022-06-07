package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No16435 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int leng = Integer.parseInt(st.nextToken(" "));

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if(leng >= arr[i]){
                leng += 1;
                continue;
            }else{
                System.out.println(leng);
                return;
            }
        }

        System.out.println(leng);


    }
}
