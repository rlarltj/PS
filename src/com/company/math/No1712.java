package com.company.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1712 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fixCost = Integer.parseInt(st.nextToken(" "));
        int varCost = Integer.parseInt(st.nextToken(" "));
        int price = Integer.parseInt(st.nextToken(" "));

        int margin = price - varCost;

        if(margin<= 0){
            System.out.println(-1);
        }else{
            System.out.println(fixCost/margin+1);
        }

    }
}
