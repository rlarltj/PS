package com.company.sds.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1837 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String n = s[0];
        int k = Integer.parseInt(s[1]);
        boolean[] isPrime = new boolean[k];
        // k까지의 소수를 isPrime에 저장한다.
        // 2 ,3  4, 5 , 6 , 7 ....
        Arrays.fill(isPrime, Boolean.TRUE);
        for (int i = 2; i <= k / 2; i++) {
            // i 가 소수인가?
            int idx = 2;
            while(true){
                if(i == idx) break;
                if (i % idx == 0) {
                    isPrime[i] = false;
                    break;
                }

                idx++;
            }
        }

        for (int i = 0; i < s.length; i++) {
            int a = n.charAt(i) - '0';
            for (int j = 0; j <= k / 2; j++) {
                if(isPrime[j]){
                    int r = a % j;

                }
            }
        }
    }
}
