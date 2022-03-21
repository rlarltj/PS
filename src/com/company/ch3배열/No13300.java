package com.company.ch3배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13300 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalNum = Integer.parseInt(st.nextToken(" "));
        int limitNum = Integer.parseInt(st.nextToken(" "));
        int[][] house = new int[6][2];
        for(int i =0; i< totalNum; i++){

                st = new StringTokenizer(br.readLine());
                int sex = Integer.parseInt(st.nextToken(" "));
                int age = Integer.parseInt(st.nextToken(" "));
                house[age-1][sex]++;

        }
        int roomNum = 0;
        for(int i =0; i<6; i++){
            for(int j =0; j<2; j++){
                if(house[i][j]> 0  && house[i][j]<= limitNum) roomNum++;
                else if(house[i][j]>limitNum) {
                    while(house[i][j]>0){
                        house[i][j] -= limitNum;
                        roomNum++;
                    }
                }
            }
        }

        System.out.println(roomNum);

    }
}
