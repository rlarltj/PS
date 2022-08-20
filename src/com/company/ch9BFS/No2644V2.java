package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2644V2 {
    static int ans = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken(" "));
        int b = Integer.parseInt(st.nextToken(" "));

        int num = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n+1];
        ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aList.add(new ArrayList<>());
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken(" "));
            int y = Integer.parseInt(st.nextToken(" "));

            aList.get(x).add(y);
            aList.get(y).add(x);
        }
        bfs(aList, visit, a, b, 0);

        System.out.println(ans);
    }

    private static void bfs(ArrayList<ArrayList<Integer>> a, boolean[] visit, int start, int fin, int count) {
        visit[start] = true;

        for(int i : a.get(start)){
            if(!visit[i]){
                if(i == fin){
                    ans = count+1;
                    return;
                }
            }
        bfs(a, visit, i, fin, count+1);

        }
    }
}
