package com.company.ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10845 {
    public static void main(String[] args) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[num];
        int tail = 0;
        int head = 0;

        for (int i = 0; i < num; i++) {
            String comm = br.readLine();

            if(comm.contains("push")){
               int n = Integer.parseInt(comm.split(" ")[1]);
               push(arr, n, tail);
               tail++;
            }
            else if(comm.contains("pop")){
                sb.append(pop(arr, head, tail)).append('\n');
                if(head != tail) head++;
            }
            else if(comm.contains("size")){
                sb.append(size(head, tail)).append('\n');
            }
            else if(comm.contains("empty")) {
                sb.append(empty(arr, head, tail)).append('\n');
            }
            else if(comm.contains("front")){
                sb.append(front(arr, head, tail)).append('\n');
            }
            else if(comm.contains("back")){
                sb.append(back(arr, head, tail)).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void push(int[] arr, int n, int tail){
        arr[tail] = n;
    }

    static int pop(int[] arr, int head, int tail) {
        if(tail-head == 0) return -1;

        return arr[head];
    }

    static int size(int head, int tail) {
        return  tail-head;
    }

    static int empty(int[] arr, int head, int tail ) {
        if(tail-head ==0 ){
            return 1;
        }else{
            return 0;
        }
    }
    static int front(int[] arr, int head, int tail) {
        if(tail-head == 0) return -1;
        else return arr[head];
    }

    static int back(int[] arr, int head, int tail) {
        if(tail-head == 0) return -1;
        else return arr[tail-1];
    }
}
