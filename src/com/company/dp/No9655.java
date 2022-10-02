package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9655 {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if(n % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}
