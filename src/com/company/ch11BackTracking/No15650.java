package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15650 {
    static int num, size = 0;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken(" "));
        size = Integer.parseInt(st.nextToken(" "));
        arr = new int[size+1];
        solve(0, 1);

    }

    private static void solve(int depth, int start) {
        if(depth == size){
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= num; i++) { // num = 3 , size = 1
                arr[depth] = i;
                solve(depth + 1, i + 1);
            }
        }
    }

