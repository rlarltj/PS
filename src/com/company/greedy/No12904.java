package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No12904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());
        int k = t.length()-s.length();
        for(int i =0; i<k; i++){

            if(t.charAt(t.length()-1) == 'A'){
                t = t.delete(t.length()-1, t.length());
            }else{
                t = t.delete(t.length()-1, t.length());
                t = t.reverse();
            }
        }

        if(t.toString().equals(s.toString())) System.out.println(1);
        else System.out.println(0);

    }
}
