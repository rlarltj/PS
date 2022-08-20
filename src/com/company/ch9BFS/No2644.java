package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2644 {
    static int n, a, b, num;
    static int[][] arr;
    static boolean[] visit;
    static Queue<Integer> qu;
    static int count = 0;
    static int[] ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken(" "));
        b = Integer.parseInt(st.nextToken(" "));

        num = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];

        arr = new int[n+1][n+1];
        ans = new int[n+1];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken(" "));
            int y = Integer.parseInt(st.nextToken(" "));
            arr[x][y] = arr[y][x] = 1;
        }
        qu = new LinkedList<>();
        bfs(a);


    }

    private static void bfs(int a) {
        qu.offer(a);
        visit[a] = true;
        ans[a] = 0;
        Loop1: while (!qu.isEmpty()) {
            int p = qu.poll();
            for (int i = 1; i < n; i++) {
                if(arr[p][i] == 1 && !visit[i]){
                    qu.offer(i);
                    visit[i] = true;
                    ans[i] = ans[p]+1;

                    if(i == b){
                        break Loop1;
                    }
                }
            }
        }

        if(ans[b] == 0){
            System.out.println(-1);
            return;
        }else{
            System.out.println(ans[b]);
        }
    }
}
