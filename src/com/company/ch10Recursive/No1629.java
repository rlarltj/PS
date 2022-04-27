package com.company.ch10Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1629 {
    public static long c;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken(" "));
        long b = Long.parseLong(st.nextToken(" "));
        c = Long.parseLong(st.nextToken(" "));

        System.out.println(pow(a, b));
    }

    private static long pow(long a, long b) {
        if(b == 1) return a % c;

        long temp = pow(a, b/2);

        if(b % 2 == 1 ){
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }
}
