package com.company;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightNumBig {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[size+1];
        int[] result = new int[size+1];

        for(int i = 1; i<size+1; i++){
            arr[i] = Integer.parseInt(st.nextToken(" "));
         }

        stack.push(1);

        for(int i =2; i<size+1; i++){
            if(stack.isEmpty()) stack.push(i);

            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.peek()] = -1;
            stack.pop();
        }

        for(int i =1 ; i<size+1; i++){
           bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();

    }
}
