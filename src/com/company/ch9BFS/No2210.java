package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2210 {
    public static int [][] arr;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[] answer ;
    public static ArrayList<String> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        arr = new int[5][5];
        answer = new int[6];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i,j,1);
            }
        }

        System.out.println(list.size());

    }

    private static void dfs(int x, int y, int depth) {
        if(depth>6){
            String str = "";
            for (int i = 0; i < answer.length; i++) {
                str += answer[i];
            }

            if(list.indexOf(str) < 0){
                list.add(str);
            }
            return;
        }


        answer[depth-1] = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && ny>= 0 && nx<5 && ny<5)
            dfs(nx, ny, depth+1);
        }
    }
}
