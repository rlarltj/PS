package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2042V2 {
    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        K = Integer.parseInt(st.nextToken(" "));

        nums = new long[N];
        S = 1;
        while (S < N) {
            S *= 2;
        }

        tree = new long[S * 2];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        initBU(); // 초기화

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));

            if (a == 1) {
                //update
                int b = Integer.parseInt(st.nextToken(" "));
                long c = Long.parseLong(st.nextToken(" "));
                long diff = c - tree[S + b - 1];
                update(1, S, 1, b, diff);
            } else {
                //구간합 출력
                int b = Integer.parseInt(st.nextToken(" "));
                int c = Integer.parseInt(st.nextToken(" "));
                System.out.println(queryBU(b, c));
            }
        }

    }


    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < N; i++) {
            tree[S+i] = nums[i];
        }

        // 내부노드 채움
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관이 없음 -> 결과에 영향이 없는 값 return
        if (queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 판단불가, 자식에게 위임, 자식에서 올라온 합을 return
        else {
            int mid = (left + right) / 2;
            long leftResult = query(left, mid, node * 2, queryLeft, queryRight);
            long rightResult = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);

            return leftResult + rightResult;
        }

    }

    static void update(int left, int right, int node, int target, long diff) {
        //연관없음
        if (target < left || target > right) {
            return;
        }
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff전달
        else {
            tree[node] += diff;
            if(left != right){
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    static long queryBU(int queryLeft, int queryRight) {
        // Leaf 에서 left, right 설정
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;
        long sum = 0;

        while (left <= right) {
            // 좌측 노드가 홀수이면 현재 노드 값 사용하고 한칸 옆으로
            if (left % 2 == 1) {
                sum += tree[left++];
            }
            // 우측 노드가 짝수이면 현재 노드 값 사용하고 한칸 옆으로
            if (right % 2 == 0) {
                sum += tree[right--];
            }
            // 좌측,우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value) {
        //Leaf에서 target을 찾음
        int node = S + target - 1;
        //value 반영
        tree[node] = value;
        //Root에 도달할 때 까지 부모에 값 반영
        node /= 2;
        while(node>0){
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node/=2;
        }

    }
}
