package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No2170 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken(" "));
            arr[i][1] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int begin = arr[0][0];
        int end = arr[0][1];
        long sum = end - begin;

        for (int i = 1; i < num; i++) {
            if(begin<= arr[i][0] && arr[i][1]<= end) continue;
            else if(arr[i][0] < end){
                sum+= arr[i][1]-end;
            }
            else{
                sum += arr[i][1]- arr[i][0];
            }
            begin = arr[i][0];
            end = arr[i][1];
        }
        System.out.println(sum);
//        System.out.println(Arrays.deepToString(arr));

    }
}
