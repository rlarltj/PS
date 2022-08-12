package com.company.programmers.test1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ContainerBelt {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 1, 2, 5};
        solution(arr);
    }

    static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < order.length; i++) {
            qu.offer(i + 1);
        }

        int idx = 1;
        for (int i = 0; i < order.length; i++) {
            int a = order[i];

            // 4  3  1  2  5
            if (qu.peek() != a) {
                while (true) {
                    st.push(idx);
                    idx++;
                    qu.poll();  //qu.peek() == 4
                    if (idx == a) {
                        break;
                    }
                }
            }

            if(qu.peek() == a){
                answer ++;
                qu.poll();
                continue;
            } else if (st.peek() == a) {
                st.pop();
                answer ++;
                continue;
            } else{
                break;
            }
        }
        return answer;
    }
}
