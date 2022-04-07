package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Sensors {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int senNum = Integer.parseInt(br.readLine());
        int zipNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int [senNum];
        for (int i = 0; i < senNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr);
//   3 6 7 8 10 12 14 15 18 20
//   3 1 1 2 2 2 1 3 2
        // ==>   1 1 1 2 2 2 2 3 3
        // ==>   3 3 2 2 2 2 1 1 1
        Integer[] diff = new Integer[senNum-1];
        for(int i =0; i<senNum-1; i++){
            diff[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());
        int sum = 0;
        for(int i = zipNum-1;  i< senNum-1; i++){
            sum += diff[i];
        }

        System.out.println(sum);




    }
}
