package com.company.greedy;

import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Rope {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] ropes = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ropes[i] = scanner.nextInt();
        }

        Arrays.sort(ropes);

        int max = ropes[N];

        for (int i = 1; i < N; i++) {
            max = Math.max(max, ropes[i] * (N - (i - 1)));
        }

        System.out.println(max);

    }

}
