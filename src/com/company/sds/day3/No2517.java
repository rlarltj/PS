package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2517 {
    static int n;
    static int[] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        List<Runner> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Runner(i, Integer.parseInt(br.readLine())));
        }

        Collections.sort(list, (o1, o2) -> o1.speed - o2.speed);
        for (int i = 0; i < list.size(); i++) {
            Runner runner = list.get(i);
            runner.speed = i+1;
        }
        //지금 왼쪽에 있는 사람은 나보다 실력이 낮은 사람이다.

        Collections.sort(list, (o1, o2) -> o1.idx - o2.idx);

        tree = new int[n * 4]; // 8 * 4 = 32
        for (int i = 1; i <= n; i++) {
            int skill = list.get(i - 1).speed;
            sb.append(i - query(1, n, 1, 1, skill));
            sb.append('\n');
            update(1, n, 1, skill);
        }
        System.out.println(sb.toString());
    }

    static int query(int left, int right, int node, int queryLeft, int queryRight) {
        if (right < queryLeft || left > queryRight) {
            return 0;
        }

        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
            int mid = (left + right) / 2;
            int leftResult = query(left, mid, node * 2, queryLeft, queryRight);
            int rightResult = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);

            return leftResult + rightResult;

    }

    static int update(int left, int right, int target, int idx) {
        if (idx < left || idx > right) {
            return tree[target];
        }
        if (left == right) {
            return tree[target] += 1;
        }
            int mid = (left + right) / 2;
            return tree[target] = update(left, mid, target * 2, idx) +
                    update(mid + 1, right, target * 2 + 1, idx);

    }
    static class Runner{
        int idx;
        int speed;

        public Runner(int idx, int speed) {
            this.idx = idx;
            this.speed = speed;
        }
    }
}
