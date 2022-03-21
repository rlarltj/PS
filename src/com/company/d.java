package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String[] arr = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if(word.contains(arr[i])){
                word = word.replaceAll(String.valueOf(arr[i]), String.valueOf(i+1));
            }
        }

        System.out.println(word);
    }
}
