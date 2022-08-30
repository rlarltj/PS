package com.company.programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Scoville {
    public static void main(String[] args) {

        int[] arr = {0,0,0};
        System.out.println(solution(arr, 7));
    }

    static int solution(int[] arr, int K) {
        int answer = 0;

        PriorityQueue<Integer> qu = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < arr.length; i++) {
            qu.offer(arr[i]);
        }
        while (qu.peek() < K) {
            if(qu.size() == 2){
                int a = qu.poll();
                int b = qu.poll();

                if (a + b * 2 < K) {
                    return -1;
                }else{
                    answer++;
                }

                break;
            }

            int a = qu.poll();
            int b = qu.poll();

            qu.offer(a + b * 2);

            answer++;
        }


        System.out.println(answer);
        return answer;
    }
}
