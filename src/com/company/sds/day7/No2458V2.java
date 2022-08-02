package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2458V2 {
    static int n, m;
    static ArrayList<Integer> adj[];
    static int[] inCnt;
    static int[] outCnt;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        adj = new ArrayList[n + 1];
        inCnt = new int[n + 1];
        outCnt = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));

            adj[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            outCnt[i] = dfs(i) - 1;
        }
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if ((inCnt[i] + outCnt[i]) == n - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int curr) {
        int outCnt = 0;

        for(int next : adj[curr]){
            if(visit[next]) continue;

            inCnt[next] ++;
            visit[next] = true;
            outCnt += dfs(next);
        }
        return outCnt +1;
    }
}
