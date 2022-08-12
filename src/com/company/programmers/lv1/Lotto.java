package com.company.programmers.lv1;

import java.io.BufferedReader;

public class Lotto {
    public static void main(String[] args) {


    }

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zCnt = 0;
        int sameCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zCnt++;
                continue;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    sameCnt++;
                    break;
                }
            }
        }

        int max = 7 - (zCnt + sameCnt);
        int min = 7 - sameCnt;
        if(sameCnt <=1) min = 6;
        if(max == 7){
            max = 6;
        }
        answer[0] = max;
        answer[1] = min;

        return answer;
    }
}
