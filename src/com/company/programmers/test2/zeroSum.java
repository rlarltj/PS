package com.company.programmers.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class zeroSum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[]{-3, -2, -1, 0, 1, 2, 3};

        solution(arr);
    }

    static int solution(int[] number) {
        int answer = 0;

        int length = number.length;
        int sum;
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                for (int k = j+1; k < length; k++) {
                    sum = 0;

                    sum = number[i] + number[j] + number[k];
                    if(sum == 0) answer++;

                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
