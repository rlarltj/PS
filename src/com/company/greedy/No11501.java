package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No11501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < num; i++) {
            int day = Integer.parseInt(br.readLine());
            int[] arr = new int[day];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < day; j++) {
                arr[j] = Integer.parseInt(st.nextToken(" "));
            }

            int max = 0;
            long sum = 0;
            for (int j = day - 1; j >= 0; j--) {
                if(arr[j]> max){
                    max=  arr[j];
                }else{
                    sum += (max-arr[j]);
                }
            }


            System.out.println(sum);


        }

    }
}
