package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1072 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        long x = Integer.parseInt(s[0]);
        long y = Integer.parseInt(s[1]);

        long winRate = (100 * y) / x;
        long start = 0;
        long end = 2*x;

        if (winRate >= 99) {
            System.out.println(-1);
        }else{
            while (true) {
                long mid = (start+end)/2;
                long newRate = (100 * (y+mid)) / (x+mid);

                if(winRate < newRate){
                    end = mid;
                }else{
                    start = mid+1;
                }

                if(start >= end) break;
            }
        System.out.println(end);
        }
    }
}
