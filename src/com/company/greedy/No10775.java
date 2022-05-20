package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10775 {
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i=0;i<P;i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);
            if (emptyGate != 0) {
                ans++;
                union(emptyGate, emptyGate - 1);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x!=y)
            parent[x] = y;
    }
}
