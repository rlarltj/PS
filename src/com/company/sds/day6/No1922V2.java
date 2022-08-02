package com.company.sds.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1922V2 {
    static int n, m;
    static int[] parent;
    static List<Node> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[n + 1];
        StringTokenizer st;

        init();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            int distance = Integer.parseInt(st.nextToken(" "));
            list.add(new Node(new int[]{a, b}, distance));
        }
        Collections.sort(list);

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (!isConnect(list.get(i).node[0], list.get(i).node[1])) {
                sum += list.get(i).distance;
                unionParent(list.get(i).node[0], list.get(i).node[1]);
            }
        }
        System.out.println(sum);
    }
    static class Node implements Comparable<Node>{
        int[] node;
        int distance;

        public Node(int[] node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int getParent(int a) {
        if(parent[a] == a) return a;

        return parent[a] = getParent(parent[a]);
    }

    static void init() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    static boolean isConnect(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if(a == b) return true;

        return false;
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a > b) {
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }
}
