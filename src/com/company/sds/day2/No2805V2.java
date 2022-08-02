package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No2805V2 {
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
        int top = arr[0];
        int bottom = 0;
        int mid = 0;
        int result = 0;
        while(true){
            sum = 0;

            //중간 값을 구한다.
            mid = (top + bottom) / 2;

            for (int i = 0; i < n; i++) {
                if(arr[i] - mid > 0){
                    sum += arr[i]-mid;
                }
            }

            if(sum < m){
                top = mid-1;
            } else if (sum > m) {
                result = mid;
                bottom = mid + 1;
            } else {
                result = mid;
                break;
            }

            if(top<bottom){
                break;
            }
        }
        System.out.println(result);
    }
}
