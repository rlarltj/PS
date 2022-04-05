package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken(" "));
        int location = Integer.parseInt(st.nextToken(" "));

        boolean[] visit = new boolean[100001];
        int[] map = new int[100001];

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        visit[start] = true;
        map[start] = 0;

        while(!qu.isEmpty()){
            Integer p = qu.poll();

            int[] dist = {p+1, p-1, p*2};

            for(int i =0; i<3; i++){
                int n = dist[i];

                if(n<0 || n>100000) continue;

                if(!visit[n]){
                qu.offer(n);
                map[n] = map[p] +1;
                visit[n] = true;
                }
            }

            if(p == location){
                System.out.println(map[p]);
                break;
            }
        }

    }
}
