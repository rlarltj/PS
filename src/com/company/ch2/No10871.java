package com.company.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken(" "));
        int num = Integer.parseInt(st.nextToken(" "));

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            int a = Integer.parseInt(st.nextToken(" "));
            if(a < num){
            sb.append(a+" ");
            }
        }

        System.out.println(sb);


    }
}
