package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CardMix {
    static PriorityQueue<Integer> que = new PriorityQueue();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(br.readLine());

        for(int i =0; i<num; i++){
            que.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        if(num ==1 ) System.out.println(0);
        else{
            while(true){
                int num1 = que.poll();
                int num2 = que.poll();
                sum+=  (num1+num2);

                if(que.isEmpty()) break;

                que.offer(num1+num2);
            }


            System.out.println(sum);
        }

    }
}
