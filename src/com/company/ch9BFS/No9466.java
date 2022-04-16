package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9466 {
    static int count;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < num; i++) {

            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            count = 0;
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken(" "));
            }

            for (int k = 1; k < N + 1; k++) {
                dfs(arr[k]);
            }

            System.out.println(N-count);
        }
    }

    private static void dfs(int now) {
        if(visited[now]) return;


        visited[now] = true;
        int next = arr[now];

        if(visited[next] != true){
            dfs(next);
        }else{
            if(finished[next] != true){
                count++;
                for(int i = next; i != now; i=arr[i]){
                    count++;
                }
            }
        }

        finished[now] = true;
    }
}
