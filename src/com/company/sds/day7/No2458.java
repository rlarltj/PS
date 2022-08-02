package com.company.sds.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2458 {
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        boolean[][] isConnect = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken(" "))-1;
            int b = Integer.parseInt(st.nextToken(" "))-1;

            isConnect[a][b] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(isConnect[i][k] && isConnect[k][j]){
                        isConnect[i][j] = true;
                    }
                }
            }
        }

        int[] count = new int[n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnect[i][j] || isConnect[j][i]){
                    count[i] ++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if(count[i] == n-1)
                answer++;
        }

        System.out.println(answer);
    }
}
