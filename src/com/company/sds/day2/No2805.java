package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        long sum = 0;
        long result = 0;
        int top = arr[0], mid = 0, bot = 0;


        while (true) {
            mid = (top + bot) / 2;
            sum = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i] - mid > 0){
                    sum += arr[i] - mid;
                }
            }

            if (sum < m) {
                //합이 작은 경우는 톱을 낮춰야 한다.
                top = mid-1;
            } else if (sum == m) {
                result = mid;
                break;
            } else {
                //너무 많이 잘라서 톱을 들어올려야 함.
                result = mid;
                bot = mid+1;
            }

            if (bot > top) {
                break;
            }
        }

        System.out.println(result);
    }
}
