package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FiveAndSix {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken(" ");
        String b = st.nextToken(" ");

       int c = Integer.parseInt(a.replaceAll("6","5"));
       int d = Integer.parseInt(b.replaceAll("6","5"));

       int e = Integer.parseInt(a.replaceAll("5","6"));
       int f = Integer.parseInt(b.replaceAll("5","6"));
        int min = c+d;
        int max = e+f;
        System.out.print(min+" "+max);

    }
}
