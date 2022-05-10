package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No19539 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        int sum = 0;
        int num = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
            sum += arr[i];
            if (arr[i] % 2 == 1) {
                num++;
            }
        }

        if (sum % 3 == 0 && num <= sum / 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
