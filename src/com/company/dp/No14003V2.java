package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No14003V2 {
    static int n;
    static int[] dp;
    static int[] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int length = 0;
        int[] lisIndex = new int[n + 1];

        List<Integer> list = new ArrayList<>();
        dp[0] = -1000000001;

        for (int i = 1; i <= n; i++) {
            if (dp[length] < nums[i - 1]) {
                dp[++length] = nums[i - 1];
                lisIndex[i] = length;
            }else{
                int index = binarySearch(1, length, nums[i - 1]);
                dp[index] = nums[i - 1];
                lisIndex[i] = index;
            }
        }

        for (int i = n; i > 0 && length > 0; i--) {
            if (length == lisIndex[i]) {
                list.add(nums[i - 1]);
                length--;
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int start, int end, int num) {
        int mid;
        while (start < end) {
            mid = (start + end) / 2;

            if(num < dp[mid]) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
