package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int k = Integer.parseInt(st.nextToken(" "));
        // 13 2      0 3 2
        int answer = 0;
        while (true) {
            int tmp = n + answer;
            int count = 0;

            while(tmp>0){
                if (tmp % 2 != 0) {
                    count++;
                }
                tmp /= 2;
            }

            if(count <= k){
                break;
            }

            answer++;

        }

        System.out.println(answer);
    }
}
