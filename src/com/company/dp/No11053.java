package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11053 {
    static int[] arr;
    static int[] lis;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis = new int[n];

        lis[0] = arr[0];

        int idx = 1;

        for (int i = 1; i < n; i++) {
            if (lis[idx - 1] < arr[i]) {
                lis[idx++] = arr[i];
            } else if (lis[0] > arr[i]) {
                lis[0] = arr[i];
            }
            else{
                int tmp = Arrays.binarySearch(lis, 0, idx, arr[i]);
                lis[tmp < 0 ? -(tmp + 1) : tmp] = arr[i];
            }
        }

        System.out.println(idx);
    }

    static int binarySearch(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (lis[mid] < target) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return right;
    }
}
