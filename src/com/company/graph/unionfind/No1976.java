package com.company.graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1976 {
    static int n , m;
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] connect = new int[n + 1][n + 1];
        int[] map = new int[m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(st.nextToken());
                connect[i][j] = a;
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (connect[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        for (int i = 1; i < m; i++) {
            int p = getParent(map[0]);

            if (getParent(map[i]) != p) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }

    static int findParent(int a) {
        if (parent[a] == a) {
            return parent[a];
        }
        else{
            return parent[a] = findParent(parent[a]);
        }
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x == y) {
            return;
        }

        if (x > y) {
            parent[x] = y;
        }else{
            parent[y] = x;
        }
    }

    static int getParent(int a) {
        return parent[a];
    }
}
