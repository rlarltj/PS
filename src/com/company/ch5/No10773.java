package com.company.ch5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(n);
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }

        System.out.println(sum);
    }
}
