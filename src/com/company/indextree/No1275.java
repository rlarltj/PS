package com.company.indextree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1275 {
    static int S = 1;
    static int N, Q;

    static long[] nums;
    static long[] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        while (S < N) {
            S *= 2;
        }

        tree = new long[S * 2];
        nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        init();

        int x, y, a;
        long b;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Long.parseLong(st.nextToken());

            System.out.println(query(x, y));
            update(a, b);
        }
    }

    private static void update(int target, long value) {
        int node = target + S - 1;
        tree[node] = value;
        node /= 2;

        while (node != 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }

    private static long query(int x, int y) {
        int left = Math.min(x, y);
        int right = Math.max(x, y);

        int queryleft = S + left - 1;
        int queryright = S + right - 1;
        long sum = 0;
        while (queryleft <= queryright) {
            if (queryleft % 2 == 1) {
                sum += tree[queryleft++];
            }

            if (queryright % 2 == 0) {
                sum += tree[queryright--];
            }

            queryleft /= 2;
            queryright /= 2;
        }

        return sum;
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            tree[S+i] = nums[i];
        }

        for (int i = S-1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
}
