package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2243 {
    static int n;
    static int[] tree;
    static int MAX = 1000000;
    static int S;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        S = 1;
        while (S < MAX) {
            S *= 2;
        }

        tree = new int[S * 2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken(" "));

            if (comm == 1) {
                //사탕을 꺼내는 경우
                //k등 맛의 사탕을 꺼낸 뒤 출력한다.
                int k = Integer.parseInt(st.nextToken(" "));
                int index = query(1, S, 1, k);
                update(1, S, 1, index, -1);
                System.out.println(index);
            }else{
                //사탕을 넣는 경우  taste맛에 candyNum만큼 update.
                int taste = Integer.parseInt(st.nextToken(" "));
                int candyNum = Integer.parseInt(st.nextToken(" "));
                update(1, S, 1, taste, candyNum);
            }
        }

    }
    static int query(int left, int right, int node, int count){
        if (left == right) {
            return left;
        }else{
            int mid = (left + right) / 2;
            if(tree[node*2] >= count){
                return query(left, mid, node * 2, count);
            }else{
                return query(mid + 1, right, node * 2 + 1, count - tree[node * 2]);
            }
        }
    }

    static void update(int left, int right, int node, int index, long diff) {
        if (left <= index && index <= right) {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, index, diff);
                update(mid + 1, right, node * 2 + 1, index, diff);
            }
        }
    }
}
