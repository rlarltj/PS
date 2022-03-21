package com.company.ch4LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class KeyLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();

        for(int i =0; i<num; i++){
        String s = br.readLine();  // <<BP<A>>Cd-  ==> BAPC
            for(int j = 0; j<s.length(); j++){
                String comm = String.valueOf(s.charAt(j));

                if(comm.equals("<")){
                    if(!st1.isEmpty()) st2.push(st1.pop());
                }else if(comm.equals(">")){
                    if(!st2.isEmpty()) st1.push(st2.pop());
                }else if(comm.equals("-")){
                    if(!st1.isEmpty()) st1.pop();
                }else{
                    st1.push(comm);
                }
            }
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            while(!st2.isEmpty()){
                sb.append(st2.pop());
            }
            sb.append('\n');
            st1.clear();
            st2.clear();
        }

        System.out.println(sb);
    }
}
