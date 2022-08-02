package com.company.sds.day1.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759 {
    static int n, m;
    static char[] answer;
    static char[] arr;
    static int selectedCount = 0;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        answer = new char[n];
        arr = new char[m];
        visited = new boolean[m];
        String s = br.readLine();
        for (int i = 0; i < m; i++) {
            arr[i] = s.split(" ")[i].charAt(0);
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            dfs(i);
        }

        System.out.println(sb);
    }

    private static void dfs(int num) {
//        1. 체크인   ==> 정렬했으므로 체크인과 체크아웃은 생략해도 된다.
        visited[num] = true;
        selectedCount++;
//        2. 목적지인가?
        if(selectedCount == n){
            //계산 + 자음 모음 검사
            if(possibility()){
                printWord();
            }
        }

//        3. 연결된 곳
        for (int i = num+1; i < m; i++) {
//        4. 갈 수 있는가?
            if(!visited[i]){
//        5. 간다
                dfs(i);
            }
        }
//        6. 체크아웃
        visited[num] = false;
        selectedCount--;



    }

    private static void printWord() {
        for (int i = 0; i < m; i++) {
            if(!visited[i]) continue;

            sb.append(arr[i]);
        }
        sb.append('\n');

    }

    private static boolean possibility() {
        //자음과 모음의 개수를 검사한다.
        int v = 0; // 자음
        int c = 0; // 모음

        for (int i = 0; i < m; i++) {
            if(!visited[i]){
                continue;
            }

            if(arr[i] == 'a' || arr[i] =='e' || arr[i] =='i' || arr[i] == 'o' || arr[i] == 'u'){
                c++;
            }else{
                v++;
            }
        }
        if(c<= 0 || v <2){
            return false;
        }

        return true;
    }
}
