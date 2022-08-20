package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11724 {
    static int n,m;
    static int[][] arr;
    static boolean[] visit;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        arr = new int[n+1][n+1];
        visit = new boolean[n+1];
        count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));

            arr[a][b] = arr[b][a] = 1;
        }

        for(int i = 1; i<n+1; i++){
            if(!visit[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        visit[i] = true;

        for (int j = 1; j < n + 1; j++) {
            if(arr[i][j] == 1 && !visit[j]){
                dfs(j);
            }
        }
    }

    private static void bfs(int i){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(i);
        visit[i] = true;

        while (!qu.isEmpty()) {
            int p = qu.poll();

            for(int j = 1; j<= n; j++){
                if(arr[p][j] == 1 && !visit[j]){
                    qu.offer(j);
                    visit[j] = true;
                }
            }
        }

    }
}
