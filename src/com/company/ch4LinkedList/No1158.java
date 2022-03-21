package com.company.ch4LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class No1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken(" "));
        int turn = Integer.parseInt(st.nextToken(" "));

        LinkedList<Integer> list = new LinkedList<>();

        StringBuffer sb = new StringBuffer();
        int head = 0;
        int tail = num;

        for(int i = 1 ; i<= num ; i++){
            list.add(i);
        }

        sb.append("<");
        while(!list.isEmpty()){
            if(list.size() == 1 ){
                sb.append(list.remove());
                break;
            }
            for(int i =0; i<turn; i++){
                    if(i == turn-1){
                        sb.append(list.remove()+", ");
                    }
                    else{
                        list.add(list.remove());
                    }

                }
           }

        sb.append(">");
        System.out.println(sb);
    }
}
