package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1343 {
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String s1 = s.replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");

    if(s1.contains("X"))
        System.out.println(-1);
    else
        System.out.println(s1);
    }
}
