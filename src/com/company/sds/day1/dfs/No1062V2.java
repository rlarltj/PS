package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1062V2 {
    static int n, k;
    static String[] word;
    static boolean[] isUsed;
    static int max = 0;
    static int selectedCount = 0;
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
//            s.replaceAll("[antic]", "");
            String s1 = s.replace("anta", "")
                    .replace("tica","");
            word[i] = s1;
        }

        isUsed = new boolean[26];
        isUsed['a'-'a'] = true;
        isUsed['c'-'a'] = true;
        isUsed['n'-'a'] = true;
        isUsed['t'-'a'] = true;
        isUsed['i'-'a'] = true;

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int depth, int start) {
        if(depth == k-5){
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if(!isUsed[word[i].charAt(j) -'a'])
                        flag = false;
                }

                if(flag){
                    count++;
                }
            }
            max = Math.max(count, max);
            //종료 조건
            return;
        }

        for (int i = start; i < 26; i++) {
            if(!isUsed[i]){
                isUsed[i] = true;
                solve(depth+1, i+1);
                isUsed[i] = false;
            }
        }

    }
    static void dfs(int index){
//        1. 체크인
        isUsed[index] = true;
        selectedCount++;
//        2. 목적지인가? : selectedCount == k  ==> 읽을 수 있는 단어의 개수를 계산한다.
        if(selectedCount == k){
            max = Math.max(countWord(), max);

        }
//        3. 연결된 곳을 순회 : index + 1 부터 z까지
        for (int i = index + 1; i <= 25; i++) {
//            4. 갈 수 있는가? : 방문 여부
            if(!isUsed[i]){ // 방문한 적이 없으면
//                5. 간다
                dfs(i);
            }
        }
//        6. 체크아웃
        isUsed[index] = false;
        selectedCount--;
    }

    static int countWord() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isPossible = true;
            String w = word[i];
            for (int j = 0; j < w.length(); j++) {
                if(!isUsed[w.charAt(j) - 'a']){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                count++;
            }
        }
        return count;
    }
}
