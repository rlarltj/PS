package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        Stack<String> st = new Stack<>();
        int point = 0;
        int multiply = 1;
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
//  (()[[]])([])
            if(s.equals("(")){
                st.push(s);
                multiply *= 2;
            }else if(s.equals("[")){
                st.push(s);
                multiply *= 3;
            }else if(!st.isEmpty() && s.equals(")")){
                if(st.peek().equals("(")){
                    point += multiply;
                    st.pop();
                    multiply /= 2;
                }else{
                    System.out.println(0);
                    return;
                }
//(()[[]])([])
            }else if(!st.isEmpty() && s.equals("]")){
                if(st.peek().equals("[")){
                    point += multiply;
                    st.pop();
                    multiply /= 3;
                }else{
                    System.out.println(0);
                    return;
                }
            }
        }
        if(!st.isEmpty()) System.out.println(0);
        else
        System.out.println(point);
    }
}
