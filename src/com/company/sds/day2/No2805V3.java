package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805V3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        int[] tree = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken(" "));
            max = Math.max(tree[i], max);
        }

        int low = 0;
        int high = max;
        int mid = 0;
        int result = 0;
        while (true) {
            mid = (high + low) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(tree[i] > mid){
                    sum += tree[i] - mid;
                }
            }

            if(sum == m){
                result = mid;
                break;
            }
            else if(sum > m){
                //너무 많이 자른경우
                low = mid + 1;
                result = mid;
            }else if(sum < m){
                //너무 조금 자른경우
                high = mid -1;
            }

            if(high < low) break;
        }

        System.out.println(result);
    }
}
