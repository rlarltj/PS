package com.company.ch10Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1780 {
    static int[][] paper;
    static int[] count;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        count = new int[3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken(" ")) + 1;
            }
        }

        cut(0,0,n);
        System.out.println(count[0]+"\n"+count[1]+"\n"+count[2]);

    }

    private static void cut(int r, int c, int size) {
        if(isPaper(r, c, size)){
            count[paper[r][c]] ++;
        }else{

            int newSize = size/3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cut(r+i*newSize, c+j*newSize, newSize);
                }
            }
        }
    }

    private static boolean isPaper(int r, int c, int size) {
        int p = paper[r][c];

        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if(p != paper[i][j]) return false;
            }
        }

        return true;
    }
}
