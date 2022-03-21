package com.company.ch3배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10807 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[100];
        for(int i = 0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        int findNum = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i =0; i<num; i++){
            if(arr[i] == findNum) count++;
        }
        System.out.println(count);


    }
}
