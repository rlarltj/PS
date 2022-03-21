package com.company.ch4LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Cursor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuffer sb =new StringBuffer();
        Stack<String> st = new Stack<>();
        for(int i =0; i<s.length(); i++){
            st.push(String.valueOf(s.charAt(i)));
        }

        Stack<String> st2 = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            String comm = br.readLine();

            if(comm.contains("P")){
                String s1 = comm.split(" ")[1];
                st.push(s1);
            }else if(comm.contains("L")){
                if(!st.isEmpty())
                    st2.push(st.pop());
            } else if (comm.contains("D")) {
                if(!st2.isEmpty())
                    st.push(st2.pop());
            } else if (comm.contains("B")) {
                if(!st.isEmpty())
                    st.pop();
            }
        }

        while(!st.isEmpty()) {
            st2.push(st.pop());
        }
        while(!st2.isEmpty()){

            sb.append(st2.pop());
        }

    }


}
