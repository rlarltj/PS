package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for(int i =0; i<num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Queue<Integer> plusQ = new LinkedList<>();
        Deque<Integer> MinusQ = new LinkedList<>();
        Arrays.sort(arr);

        int count = 0;
        int sum = 0;
        for(int i =num-1; i>=0; i--){
            if(arr[i] >1){
                count ++;
                if(plusQ.isEmpty())
                     plusQ.add(arr[i]);
                else {
                    int a = plusQ.poll().intValue();
                    int b = arr[i];
                    sum += a * b;
                }
            }else if(arr[i] <= 0){  // 0~ 9    10개 중 6개가 양수면,   arr [0,1,2,3]  count = 6   i = 4
                    if(MinusQ.isEmpty()){
                        MinusQ.add(arr[num-count-i-1]);
                    System.out.println(arr[num-count-i-1]);
                    }
                    else{
                        int a = MinusQ.poll().intValue();
                        int b = arr[num-count-i-1];
                        sum += a * b;
                    }
            }else if(arr[i] == 1) {
                sum++;
                count++;
            }
        }
        if(!plusQ.isEmpty()) sum+= plusQ.poll();
        if(!MinusQ.isEmpty()) sum+= MinusQ.poll();


        System.out.println(sum);
//        마이너스가 짝수개면 마이너스끼리 묶는다
//        마이너스가 홀수개면 마이너스끼리 묶고, 마지막은 0이랑 묶거나, 0이 없는 경우 그냥 둠
//        마이너스가 없으면, 큰 수끼리 곱한다.


    }
}
