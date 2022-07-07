package com.company.ch11BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759 {
    static int n, m;
    static char[] arr;
    static char[] answer;
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[m];
        answer = new char[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr[i] = s[i].charAt(0);
        }
        Arrays.sort(arr);

        solve(0, 0);
        System.out.println(sb);
    }

    private static void solve(int depth, int start) {
        if(depth == n){
            if(!request(answer)) return; // 모음과 자음의 개수 조건을 만족시켰는가
            for (int i = 0; i < n; i++) {
                sb.append(answer[i]);
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < m; i++) {
            char now = arr[i];
            answer[depth] = now;
            solve(depth+1, i+1);
        }
    }

    private static boolean request(char[] answer) {
        int v = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < 5; j++) {
                if(answer[i] == vowel[j]) v++;
            }
        }
        int c = answer.length - v;

        if(v>0 && c>=2) return true;

        return false;
    }
}
