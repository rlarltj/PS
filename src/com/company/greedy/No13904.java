package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No13904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[][] arr = new int[num][2];
        StringTokenizer st;
        ArrayList<HomeWork> list = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken(" "));
            int v = Integer.parseInt(st.nextToken(" "));
            list.add(new HomeWork(d, v));

            maxDay = Math.max(maxDay, d);
        }

        int sum = 0;

        for (int i = maxDay; i > 0; i--) {
            HomeWork ans = new HomeWork(0, 0);

            for(HomeWork h: list){
                if(h.day>=i){
                    if(ans.value < h.value){
                        ans = h;
                    }
                }
            }

            sum += ans.value;
            list.remove(ans);
        }


        System.out.println(sum);
    }

    static class HomeWork{
        int day;
        int value;

        public HomeWork(int day, int value) {
            this.day = day;
            this.value = value;
        }
    }
}
