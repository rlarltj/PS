package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < num; i++) {
            int a = Integer.parseInt(br.readLine());
            if( a == 0 ) {
                count++;
                continue;
            }



        }
    }
}
