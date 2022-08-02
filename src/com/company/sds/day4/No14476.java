package com.company.sds.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14476 {
    public static void main(String[] args) throws IOException {
        int max = 0;
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        int[] LR = new int[num];
        int[] RL = new int[num];
        for (int i = 0; i < num; i++) {
            if(i == 0){
                LR[i] = arr[i];
                RL[num-1] = arr[num - 1];
                continue;
            }
            LR[i] = getGcd(LR[i-1], arr[i]);
            RL[num-i-1] = getGcd(RL[num-i], arr[num-1-i]);
        }

        for (int i = 0; i < num; i++) {
            int k = arr[i];
            int gcd = 0;
            if (i == 0) {
                gcd = RL[1];
            }else if(i == num-1){
                gcd = LR[num-2];
            }else{
                gcd = getGcd(LR[i-1], RL[i+1]);
            }

            if(k/gcd == 0) continue;
            else{
                max = Math.max(max, gcd);
                result = k;
            }

        }
        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(max+" "+result);

        }
    }

    static int getGcd(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        int r = big % small;

        if( r == 0 ){
            return small;
        }

        return getGcd(small, r);
    }
}
