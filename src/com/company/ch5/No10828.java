package com.company.ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int cursor = 0;
        StringBuffer sb = new StringBuffer();

        for(int i =0; i<num; i++){
            String comm = br.readLine();

            if(comm.contains("push")){
                int n = Integer.parseInt(comm.split(" ")[1]);
                push(arr, cursor, n);
                cursor++;
            }else if(comm.contains("top")){
                sb.append(top(arr, cursor)).append('\n');
            }else if(comm.contains("empty")){
                sb.append(empty(cursor)).append('\n');
            }else if(comm.contains("size")){
               sb.append(size(cursor)).append('\n');
            }else if (comm.contains("pop")){
                sb.append(pop(arr, --cursor)).append('\n');
            }
        }
        System.out.println(sb);
    }


    static void push(int[] arr ,int cursor, int n) {
        arr[cursor] = n;
    }

    static int top(int[] arr, int cursor) {
        if(cursor == 0) {
            return -1;
        } else return arr[--cursor];
    }

    static int empty(int cursor) {
        if(cursor == 0){
            return 1;
        }
        return 0;
    }

    static int pop(int[] arr, int cursor) {
         if(cursor>=0){
             return arr[cursor];
         }else{
             return -1;
         }
    }

    static int size(int cursor) {
        return cursor;
    }
}
