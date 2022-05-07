package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No19939 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ball = Integer.parseInt(st.nextToken(" "));
        int k = Integer.parseInt(st.nextToken(" "));

        int[] arr = new int[k];

        if(k>=ball) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < k; i++) {
            arr[i] = i+1;
            ball -= arr[i];

            if(ball<0) {
                System.out.println(-1);
                return;
            }
        }

        while(ball >= k){
            ball -=k;
            for (int i = 0; i < k; i++) {
                arr[i]++;
            }
        }

        if(ball != 0){
            arr[k-ball] += ball;
        }
        Arrays.sort(arr);
        System.out.println(arr[k-1] - arr[0]);

    }
}
