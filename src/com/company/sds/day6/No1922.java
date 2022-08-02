package com.company.sds.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1922 {
    static int n, m;
    static int[] parent;
    static List<Node> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        list = new ArrayList<>();
        init();
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            int distance = Integer.parseInt(st.nextToken(" "));
            //TODO 출발-도착지가 같은 경우, 비용이 적은 것으로 갱신한다.

            list.add(new Node(new int[]{a,b}, distance));

        }
        Collections.sort(list);

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            // 사이클이 발생하지 않으면 그래프에 더한다.
            if(!isConnect(list.get(i).node[0], list.get(i).node[1])){
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
        //거리 (비용) 오름차순으로 정렬한다.
    }
    static void init() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int getParent(int a) {
        if(parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
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

    static boolean isConnect(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if(a == b) return true;
        else return false;
    }
}
