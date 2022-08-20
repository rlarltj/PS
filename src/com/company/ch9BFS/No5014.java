package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5014 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int floor = Integer.parseInt(st.nextToken(" "));
        int start = Integer.parseInt(st.nextToken(" "));
        int fin = Integer.parseInt(st.nextToken(" "));
        int up = Integer.parseInt(st.nextToken(" "));
        int down = Integer.parseInt(st.nextToken(" "));

        int[] arr = new int[floor+1]; // arr[1] ~ arr[10]
        boolean[] visit = new boolean[floor+1];
        Queue<Integer> qu = new LinkedList<>();
        int[] dx = {up, -down};

        arr[start] = 1;
        visit[start] = true;

        qu.offer(start);
        while(!qu.isEmpty()){
           int n = qu.poll();

            for (int i = 0; i < 2; i++) {
                int nx = n+dx[i];

                if(nx<=0 || nx>floor) continue;

                if(arr[nx] == 0 && !visit[nx]){
                    qu.offer(nx);
                    arr[nx] = arr[n]+1;
                    visit[nx] = true;
                }
            }
        }
        System.out.println(arr[fin]==0? "use the stairs" : arr[fin]-1);


    }
}
