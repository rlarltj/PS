package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class AppleBasket {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int screen = Integer.parseInt(st.nextToken(" "));
        int length = Integer.parseInt(st.nextToken(" "));

        st = new StringTokenizer(br.readLine());

        int appleNum = Integer.parseInt(st.nextToken(" "));

        int[] arr = new int[appleNum];
        for (int i = 0; i < appleNum; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        /**
         * 5 1
         * 3
         * 5
         * 2
         * 1
         */


        int fin = length;
        int start = fin-(length-1);       //    1 2 3 4 5
        int count = 0;

        for(int i =0; i<appleNum; i++){

            System.out.println("count ="+count);

            if(arr[i] >= start && arr[i] <=fin){
                continue;
            }else if(arr[i] > fin){
                int gap = arr[i] - fin;
                count += gap;
                fin += gap;
                start += gap;
            }else if(arr[i] < start){
                System.out.println("start = " + start);
                int gap = start - arr[i];
                count += gap;
                start -= gap;
                fin -= gap;
            }
        }

        System.out.println(count);

    }
}
