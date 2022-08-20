package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1389 {
    static final int INF = 1_000_000_000;
    static int[][] arr;
    static Queue<Integer> qu;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;

                if(i == j) arr[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken(" "));
            int y = Integer.parseInt(st.nextToken(" "));

            arr[x][y] = arr[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            // k는 거쳐가는 노드
            for (int i = 1; i <= n; i++) {
                // i 는 출발 노드
                for (int j = 1; j <= n; j++) {
                    // j는 도착 노드
                    if(arr[i][j]> arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                        //i -> j 보다 k를 거쳐가는 경우가 더 짧다면  i -> j를 최단경로로 초기화해준다.
                    }
                }
            }
        }

        int min = INF;
        int idx = -1;
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += arr[i][j];
            }

            if(min > total){
                min = total;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
