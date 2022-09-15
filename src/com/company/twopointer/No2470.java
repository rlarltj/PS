package com.company.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2470 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] answer = getMixZero();
        System.out.println(answer[0] + " " + answer[1]);
    }
//
//  -99 -2 -1 4 98
    static int[] getMixZero() {
        int[] answer = new int[2];
        int dist = Integer.MAX_VALUE;
        int leftP = 0;
        int rightP = n - 1;

        while (leftP < rightP) {
            int sum = arr[leftP] + arr[rightP];

            if (dist > Math.abs(sum)) {
                dist = Math.abs(sum);

                answer[0] = arr[leftP];
                answer[1] = arr[rightP];

                if (sum == 0) {
                    return answer;
                }
            }

            if (sum < 0) {
                leftP ++;
            } else if (sum > 0){
                rightP --;
            }
        }

        return answer;
    }
}
