package com.company.sds.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No14002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[num + 1];
        int[] dp = new int[num + 1];
        //입력
        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        //LIS
        int result = 0;

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }
            }
        }
        sb.append(result + "\n");

        Stack<Integer> stack = new Stack<>();
        int value = result;
        for (int i = num; i > 0; i--) {
            if(value == dp[i]){
                value--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}
