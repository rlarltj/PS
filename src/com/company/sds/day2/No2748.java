package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2748 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(fibo(num));
    }

    private static long fibo(int n) {
        long a = 1;
        long b = 1;
        long c = 1;
        if(n == 1 || n ==2 ) return 1;

        for (int i = 3; i <= n; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
