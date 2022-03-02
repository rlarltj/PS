package com.company;
import java.util.*;
import java.io.*;
public class Josephus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> que = new LinkedList<>();

        int num = sc.nextInt();
        int start = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();


        for(int i =1 ; i<=num; i++){
            que.add(i);
        }

        while(!que.isEmpty()){
        for(int i = 0; i<start-1; i++){
            que.add(que.pop());
        }
            arr.add(que.pop());
        }

        System.out.println("<"+arr+">");

    }
}
