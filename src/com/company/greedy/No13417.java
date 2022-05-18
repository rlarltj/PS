package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class No13417 {
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            Deque<Character> de = new LinkedList<>();


            int n = Integer.parseInt(br.readLine());
            char[] arr = new char[n];
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[j] = s[j].charAt(0);
            }
            de.add(arr[0]);

            for (int j = 1; j < n; j++) {
                if(de.peekFirst() >= arr[j]){
                    de.offerFirst(arr[j]);
                }else{
                    de.offerLast(arr[j]);
                }
            }
            for (int j = 0; j < n; j++) {
                sb.append(de.pollFirst());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
