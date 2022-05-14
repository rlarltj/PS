package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No13975 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        PriorityQueue<Long> qu;
        for (int i = 0; i < num; i++) {
            qu = new PriorityQueue<>();

            long sum = 0;

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                qu.offer(Long.parseLong(st.nextToken(" ")));
            }

            while(qu.size()>1){
                for(int j = 0; j<n-1; j++){
                    long a = qu.poll();
                    long b = qu.poll();
                    sum += (a+b);
                    qu.add(a+b);
                }
            }

            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}
