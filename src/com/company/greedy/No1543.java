package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1543 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String word =  br.readLine();

        StringBuffer sb = new StringBuffer();

        int count = 0;


        String s = sentence.replaceAll(word, "A");

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') count++;
        }

        System.out.println(count);
        System.out.println(s);
    }
}
