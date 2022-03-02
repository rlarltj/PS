package com.company;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Deq {
   static Deque<Integer> de = new ArrayDeque<>();
   static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            String com = br.readLine();
            String[] arr = com.split(" ");

            switch(arr[0]){

                case "push_front":
                    de.addFirst(Integer.parseInt(arr[1]));
                    break;
                case "push_back":
                    de.addLast(Integer.parseInt(arr[1]));
                    break;
                case "front":
                    if(de.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(de.peekFirst()).append('\n');
                    break;
                case "back":
                    if(de.isEmpty()) sb.append(-1).append('\n');
                    else
                     sb.append(de.peekLast()).append('\n');
                    break;
                case "size":
                    sb.append(de.size()).append('\n');
                    break;
                case "empty":
                    if(de.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "pop_back":
                    if(de.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(de.pollLast()).append('\n');
                    break;
                case "pop_front":
                    if(de.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(de.pollFirst()).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

//    static void pushBack(int i){
//        de.addLast(i);
//    }
//    static void pushFront(int i ){
//        de.addFirst(i);
//    }
//    static void front(){
//        sb.append(de.peekFirst()).append('\n');
//    }
//    static void back(){
//        sb.append(de.peekLast()).append('\n');
//    }
//    static void empty(){
//        if(de.isEmpty()){
//            sb.append(1).append('\n');
//        }else sb.append(0).append('\n');
//    }
//    static void size(){
//        sb.append(de.size()).append('\n');
//    }
//    static void popFront(){
//        if(!de.isEmpty())
//        sb.append(de.poll()).append('\n');
//        else sb.append(-1).append('\n');
//    }
//    static void popBack(){
//        if(!de.isEmpty())
//        sb.append(de.pollLast()).append('\n');
//        else sb.append(-1).append('\n');
//    }
}
