package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2517V2 {

    static class Runner{
        int idx;
        int skill;

        public Runner(int idx, int talent) {
            this.idx = idx;
            this.skill = talent;
        }
    }

    static int n;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Runner> runners = new ArrayList<>();
        for(int i=0; i<n; i++) {
            runners.add(new Runner(i, Integer.parseInt(br.readLine())));
        }

        Collections.sort(runners, (a, b)-> (a.skill - b.skill));
        for(int i=0; i<runners.size(); i++) {
            Runner runner = runners.get(i);
            runner.skill = i+1;
        }
        Collections.sort(runners, (a,b)-> (a.idx - b.idx));

        StringBuilder sb = new StringBuilder();
        tree = new int[n*4];
        for(int i=1; i<=n; i++) {
            int skill = runners.get(i-1).skill;
            sb.append(i- query(1,n, 1, 1,skill) +"\n");
            update(1,n,1, skill);
        }
        System.out.println(sb.toString());
    }

    static int query(int s, int e, int node, int l, int r) {
        if(e < l || r < s) return 0;
        if(l <= s && e <= r) {
            return tree[node];
        }
        int mid = (s+e)/2;
        return query(s, mid, node*2, l, r) + query(mid+1, e, node*2+1, l, r);
    }

    static int update(int s, int e, int node, int idx) {
        if(idx < s || e < idx) return tree[node];
        if(s == e)  {
            return tree[node] += 1;
        }
        int mid = (s+e)/2;
        return tree[node] = update(s, mid, node*2, idx)+
                update(mid+1, e, node*2+1, idx);
    }
}
