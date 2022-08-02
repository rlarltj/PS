package com.company.sds.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2252 {
    static int n, m;
    static List<Integer> result;
    static int[] indegree;
    static List<List<Integer>> adj ;
    static Queue<Integer> qu = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        adj = new LinkedList<>();

        result = new LinkedList<>();

        indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(i, new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            indegree[b]++; // 간선의 개수

            adj.get(a).add(b); // a 의 연결노드 리스트에 b를 추가한다. a --> b

        }
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                //간선의 개수가 0인 노드를 전부 큐에 넣는다.
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            Integer node = qu.poll();
            result.add(node);

            for(int i : adj.get(node)){
                indegree[i] --;

                if(indegree[i] == 0 ){
                    qu.offer(i);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+" ");
        }
    }
}
