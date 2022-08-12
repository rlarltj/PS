package com.company.programmers.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class PairNumber {
    public static void main(String[] args) throws IOException {
        solution("100", "203040");

    }

    static String solution(String X, String Y) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();

        String answer = "";
        int[] numX = new int[10];
        int[] numY = new int[10];
        for (int i = 0; i < X.length(); i++) {
            numX[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            numY[Y.charAt(i) - '0']++;
        }
        int[] comm = new int[10];
        for (int i = 0; i < 10; i++) {
            comm[i] = Math.min(numX[i], numY[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < comm[i]; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) {
            answer = "-1";
        }else if(sb.charAt(0) == '0'){
            answer = "0";
        }else{
            answer = sb.toString();
        }
        return answer;
    }
}
