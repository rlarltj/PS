package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15649 {
    static int n,m;
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        //4 2      1 2  1 3  1 4 ...
        arr = new int[m+1];
        visit = new boolean[n+1];
        dfs(0);
    }

    static void dfs(int depth){
        if(depth == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}
