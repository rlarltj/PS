package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260 {
    static int n,m, start;
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        start = Integer.parseInt(st.nextToken(" "));

        arr = new int[1001][1001];
        visit = new boolean[1001];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));

            arr[a][b] = arr[b][a] =1;
        }

        dfs(start);

        visit = new boolean[1001];
        System.out.println();

        bfs(start);
    }

    private static void dfs(int start) {
        visit[start] = true;
        System.out.print(start+" ");

        for (int i = 1; i <= n; i++) {
            if(arr[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        visit[start] = true;
        System.out.print(start+" ");
        while(!qu.isEmpty()){
            Integer p = qu.poll();

            for (int i = 1; i <= n; i++) {
                if(arr[p][i] == 1 && !visit[i]){
                    qu.offer(i);
                    visit[i] = true;

                    System.out.print(i+ " ");
                }
            }
        }
    }
}
