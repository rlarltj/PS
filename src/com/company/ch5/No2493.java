package com.company.ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No2493 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        StringTokenizer sk = new StringTokenizer(br.readLine());
        for(int i =0; i<num; i++){
            st.push(Integer.parseInt(sk.nextToken(" ")));
         }


        while(!st.isEmpty()){
        st2.push(st.pop());

        if(st2.peek() > st.peek()){ // 송신 불가능
            st2.push(st.pop());
        }
        while(st2.peek() < st.peek()){  // st에 송신 가능할때까지
            st2.pop();
        }



        }



        /**
         * 4       6 9 5 7 4
         * 7
         * 5
         * 9
         * 6
         */

    }
}
