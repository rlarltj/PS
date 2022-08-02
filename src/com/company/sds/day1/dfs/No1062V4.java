package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1062V4 {
    static int n, k;
    static String[] word;
    static char[] alphabet;
    static boolean[] used;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        k = Integer.parseInt(st.nextToken(" "));

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k >= 26) {
            System.out.println(n);
            return;
        }

        word = new String[n];
        alphabet = new char[26];
        used = new boolean[26];
        used['a'-'a'] = true;
        used['c'-'a'] = true;
        used['n'-'a'] = true;
        used['t'-'a'] = true;
        used['i'-'a'] = true;
        for (int i = 0; i < n; i++) {
            String s1 = br.readLine().replace("anta", "")
                        .replace("tica", "");

            word[i] = s1;
        }

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a'+i);
        }

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int start, int depth) {

        if (depth == k - 5) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if(!used[word[i].charAt(j) -'a']){
                        flag = false;
                    }
                }
                if(flag) count ++;
            }

            max = Math.max(count, max);
            return;
        }

        for (int i = start; i < 26; i++) {
            if(!used[i]){
                used[i] = true;
                solve(i + 1, depth + 1);
                used[i] = false;
            }
        }
    }
}
