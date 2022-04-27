package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4889 {
    static int n;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        n = 1;
        while(true){
            String s = br.readLine();
            if(s.contains("-")) {
                System.out.println(sb);
                break;
            }
            count = 0;
            String[] arr = s.split("");
            Stack<String> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].equals("{")){
                    st.push(arr[i]);
                }
                else if(arr[i].equals("}")){
                    if(st.isEmpty()){
                        count++;
                        arr[i] = "{";
                        st.push(arr[i]);
                    }else{
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()){
            count += st.size()/2;
            }
            sb.append(n+". "+count).append('\n');

            n++;
        }
    }
}
