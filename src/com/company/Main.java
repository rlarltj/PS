package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
        static LinkedList<Integer> que = new LinkedList<>();

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(br.readLine());

        for(int i =0; i<num; i++){
            String com = br.readLine();
            if(com.contains("push")){
                String[] sta = com.split(" ");
                push(Integer.parseInt(sta[1]));
            }else if(com.contains("front")){
                sb.append(front()).append('\n');
            }else if(com.contains("back")){

                sb.append(back()).append('\n');
            }else if(com.contains("size")){
                sb.append(size()).append('\n');
            }else if(com.contains("pop")){
                sb.append(pop()).append('\n');
            }else if(com.contains("empty")){
                sb.append(empty()).append('\n');
            }
        }
            System.out.println(sb);
    }

    static void push(int i){
        que.add(i);
    }
    static int front(){
        if(!que.isEmpty()) return que.peek();
        else return -1;
    }
    static int back(){
        if(!que.isEmpty()) {
            return que.getLast();
        }
        else return -1;
    }
    static int size(){
        return que.size();
    }

    static int pop(){
            if(!que.isEmpty()) return que.poll();
            else return -1;
    }
    static int empty(){
            return que.isEmpty()? 1 : 0;
    }
}
