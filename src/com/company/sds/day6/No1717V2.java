package com.company.sds.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1717V2 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        parent = new int[n + 1];

        init();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken(" "));

            if (comm == 0) {
                //합집합 연산
                int a = Integer.parseInt(st.nextToken(" "));
                int b = Integer.parseInt(st.nextToken(" "));
                unionParent(a, b);
            } else {
                //집합에 포함되어있는지
                int a = Integer.parseInt(st.nextToken(" "));
                int b = Integer.parseInt(st.nextToken(" "));
                if(isConnect(a, b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    static void init() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int getParent(int a) {
        if(parent[a] == a) return a;

        return parent[a] = getParent(parent[a]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if(a>b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    static boolean isConnect(int a, int b) {
        a = getParent(a);
        b= getParent(b);

        if(a == b) return true;

        return false;
    }
}
