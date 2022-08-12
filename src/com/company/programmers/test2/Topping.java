package com.company.programmers.test2;

import java.util.HashSet;
import java.util.Set;

public class Topping {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 1, 4, 1, 2};

        solution(arr);
    }

    private static int solution(int[] topping) {
        int answer = 0;
        int length = topping.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];

        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < length; i++) {
            s1.add(topping[i]);
            leftSum[i] = s1.size();
        }

        s1 = new HashSet<>();
        for (int i = length - 1; i >= 0; i--) {
            s1.add(topping[i]);

            rightSum[i] = s1.size();
        }

        for (int i = 0; i < length-1; i++) {
            if(leftSum[i] == rightSum[i+1])
                answer ++;
        }

        System.out.println(answer);
        return answer;
    }
}
