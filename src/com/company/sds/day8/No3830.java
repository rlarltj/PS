package com.company.sds.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3830 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken(" "));
            m = Integer.parseInt(st.nextToken(" "));

            if (n == 0 && m == 0) {
                break;
            }

            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken(" ");

            int a, b;
            if(s.equals("!")){
                a = Integer.parseInt(st.nextToken(" "));
                b = Integer.parseInt(st.nextToken(" "));
                int diff = Integer.parseInt(st.nextToken(" "));
            }else{
                a = Integer.parseInt(st.nextToken(" "));
                b = Integer.parseInt(st.nextToken(" "));
            }

        }
    }

    static int getParent(int a) {
        if(parent[a] == a) return a;

        return parent[a] = getParent(parent[a]);
    }

    static void unionFind(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a > b) {
            parent[a] = b;
        }else{
            parent[b] = a;
        }

    }
}


