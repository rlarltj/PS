package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphaNum {
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        for(int i = 0; i<num; i++){
            String line = br.readLine();
            int leng =  line.length();
            int base = (int)Math.pow(10, leng-1);
            for(int x = 0; x<leng; x++){
                alpha[line.charAt(x) - 'A'] += base;
                base /= 10;
            }
        }
        Arrays.sort(alpha);

        int ans = 0;

        for(int i= 25; i>=17;  i--){
            ans += alpha[i] * (i-16);
        }

        System.out.println(ans);


    }
}
