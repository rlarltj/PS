package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No14003 {
    static int N;
    static int[] lis;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        lis = new int[N + 1];
        lis[0] = -1000000001;

        int length = 0;

        ArrayList<Integer> result = new ArrayList<>();

        int[] lisIndex = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (lis[length] < A[i - 1]) {
                lis[++length] = A[i - 1];
                lisIndex[i] = length;
            }
            else{
                int index = binarySearch(1, length, A[i - 1]);
                lis[index] = A[i - 1];
                lisIndex[i] = index;
            }
        }

        for (int i = N; i > 0 && length > 0; i--) {
            if (length == lisIndex[i]) {
                result.add(A[i - 1]);
                length --;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i) + " ");
        }

        System.out.println(sb);
    }

    static int binarySearch(int left, int right, int x) {
        //x보다 크거나 같은 수 중 가장 왼쪽에 있는 인덱스를 찾는다.
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (x > lis[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }


}
