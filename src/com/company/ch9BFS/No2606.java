package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2606 {
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int pairNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visit = new boolean[num + 1];
        int[][] arr = new int[num+1][num+1];
        for (int i = 0; i < pairNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken(" "));
            int y = Integer.parseInt(st.nextToken(" "));

            arr[x][y] = arr[y][x] = 1;
        }

        Queue<Integer> qu = new LinkedList<>();

        qu.add(1);
        visit[1] = true;

        int count = 0;
        while (!qu.isEmpty()) {
            int p = qu.poll();
            for (int i = 1; i <= num; i++) {
                if (arr[p][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    qu.offer(i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
