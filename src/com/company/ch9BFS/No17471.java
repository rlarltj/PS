//package com.company.ch9BFS;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//
//public class No17471 {
//    static int N;
//    static Position[] positions;
//    static ArrayList<ArrayList<Integer>> list;
//    static int ans = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//
//        positions = new Position[N + 1];
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 1; i <= N; i++) {
//            int peopleNum = Integer.parseInt(st.nextToken());
//            positions[i] = new Position(i, peopleNum);
//        }
//
//        list = new ArrayList<>();
//
//        for (int i = 0; i <= N; i++) {
//            list.add(new ArrayList<>());
//        }
//
//
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken(" "));
//            for (int j = 0; j < n; j++) {
//                int tmp = Integer.parseInt(st.nextToken());
//                list.get(i).add(tmp);
//            }
//        }
//
//        ArrayList<Integer> A = new ArrayList<>();
//        for (int i = 1; i <= N / 2; i++) {
//            comb(1, N, i, A);
//        }
//
//    }
//
//    private static void comb(int start, int n, int r, ArrayList<Integer> A) {
//        if(r == 0){
//            gerryMandering(A);
//            return;
//        }
//
//        for (int i = start; i <= n; i++) {
//            A.add(i);
//            comb(i + 1, n, r - 1, A);
//            A.remove(A.size()-1);
//        }
//    }
//
//    private static void gerryMandering(ArrayList<Integer> a) {
//    }
//
//    static class Position{
//        int x;
//        int peopleNum;
//
//        public Position(int x, int peopleNum) {
//            this.x = x;
//            this.peopleNum = peopleNum;
//        }
//    }
//}
