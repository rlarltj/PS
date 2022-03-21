package com.company.ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1874 {
public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();

    Stack<Integer> st = new Stack<>();
    int count = 0;
    for (int i = 0; i < num; i++) {
        int next = Integer.parseInt(br.readLine());
        //입력받은 수가 현재 스택 top보다 큰 경우, 까지 스택을 채운다.

        if(next>count){

            for(int j =count+1; j<=next; j++){
                st.push(j);
                sb.append("+").append('\n');
            }
            count = next;
        } else if(st.peek() != next) {
            System.out.println("NO");
            return;
        }
            st.pop();
            sb.append("-").append('\n');
        }
    System.out.println(sb);
    }
}



