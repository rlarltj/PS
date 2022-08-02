package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1062 {
    static int n, k;
    static boolean[] isUsed;
    static String[] word;
    static char[] alphabet;
    static char[] answer;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        //a c n t i
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        k = Integer.parseInt(st.nextToken(" "));

        if(k<5){
            System.out.println(0);
            return;
        }else if(k>=26){
            System.out.println(n);
            return;
        }

        word = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String s1 = s.replace("anta", "")
                    .replace("tica","");
            word[i] = s1;
        }
        answer = new char[k];
        alphabet = new char[26];

        isUsed = new boolean[26];
        isUsed['a'-'a'] = true;
        isUsed['c'-'a'] = true;
        isUsed['n'-'a'] = true;
        isUsed['t'-'a'] = true;
        isUsed['i'-'a'] = true;

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a'+i);
        }
        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int depth, int start) {
        if(depth == k-5){
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean read = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!isUsed[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }

                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if(alphabet[i] == 'a' || alphabet[i] == 'c' || alphabet[i] == 't' ||alphabet[i] == 'n' || alphabet[i] == 'i'){
                continue;
            }
            if(!isUsed[i]){
                isUsed[i] = true;
                solve(depth+1, start+1);
                isUsed[i] = false;
            }
        }

    }
}
