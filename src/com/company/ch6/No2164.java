package com.company.ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        Queue<Integer> q = new LinkedList<>();
        for(int i =1; i<=num; i++){
            q.add(i);
        }

        for(int i =0; i<num-1; i++){
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.poll());

    }
}
