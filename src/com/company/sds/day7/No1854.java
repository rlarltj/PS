package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No1854 {
    static int n,m,k;
    static ArrayList<Node>[] list;
    static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        k = Integer.parseInt(st.nextToken(" "));

        list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken(" "));
            b = Integer.parseInt(st.nextToken(" "));
            c = Integer.parseInt(st.nextToken(" "));

            list[a].add(new Node(b, c));
        }

        int start = 1;

        dijkstra(start);

    }

    private static void dijkstra(int start) {

    }

    static class Node implements Comparator<Node>{
        int dest;
        int time;


        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.time - o2.time;
        }
    }
}
