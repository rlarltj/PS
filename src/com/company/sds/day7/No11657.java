package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11657 {
    static int n, m;
    static final int INF = 500 * 100_000;
    static Bus[] busArr;
    static int[] dist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        busArr = new Bus[m + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken(" "));
            int dest = Integer.parseInt(st.nextToken(" "));
            int time = Integer.parseInt(st.nextToken(" "));

            busArr[i] = new Bus(start, dest, time);
        }

        StringBuilder sb = new StringBuilder();

    }

//    static boolean bellmanFord() {
//        dist[1] = 0;
//        return true;
//    }

    static class Bus{
        int start;
        int dest;
        int time;

        public Bus(int start, int dest, int time) {
            this.start = start;
            this.dest = dest;
            this.time = time;
        }
    }
}
