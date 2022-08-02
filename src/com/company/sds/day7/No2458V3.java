package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2458V3 {
    static int n, m;
    static ArrayList<Integer> adj[];
    static Student[] stdArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        adj = new ArrayList[n + 1];

        stdArr = new Student[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            stdArr[i] = new Student(0, 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));

            adj[a].add(b);
        }

        bfs();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(stdArr[i].less + stdArr[i].more == n-1){
                count ++;
            }
        }

        System.out.println(count);
    }

    private static void bfs() {

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            Queue<Integer> qu = new LinkedList<>();
            qu.offer(i);
            visit[i] = true;

            while (!qu.isEmpty()) {
                Integer p = qu.poll();

                for (int next : adj[p]) {
                    if (visit[next]) {
                        continue;
                    }

                    qu.offer(next);
                    visit[next] = true;
                    stdArr[i].more++;
                    stdArr[next].less++;


                }
            }
        }
    }

    static class Student{
        int less;
        int more;

        public Student(int less, int more) {
            this.less = less;
            this.more = more;
        }
    }

}
