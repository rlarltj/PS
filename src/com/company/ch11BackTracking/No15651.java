package com.company.ch11BackTracking;

import java.io.IOException;
import java.util.Scanner;

public class No15651 {
    static int n, size;
    static int count = 0;
    static int[] arr;
    static StringBuffer sb;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        size = sc.nextInt();
        sb = new StringBuffer();
        arr = new int[size];

        solve(0, 0);
        System.out.println(sb);
    }

    private static void solve(int depth, int s) {
        if(depth == size){
            for (int i = 0; i < size; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            solve(depth+1, s);
        }
    }
}
