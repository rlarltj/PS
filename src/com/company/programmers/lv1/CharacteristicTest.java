package com.company.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class CharacteristicTest {
    public static void main(String[] args) {
        String[] arr = {"AN", "CF", "MJ", "RT", "NA"};

        int[] c = {5, 3, 2, 7, 5};

        solution(arr, c);
    }

    static String solution(String[] survey, int[] choices) {
        char[] arr= new char[]{'R','T','C','F','J','M','A','N'};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(arr[i], 0);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < survey.length; i++) {
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);
            int choice = choices[i];

            if(choice < 4) {
                map.put(type1, map.getOrDefault(type1, 0)+ Math.abs(choice-4));
            }else{
                map.put(type2, map.getOrDefault(type2, 0) + choice-4);
            }
        }

        for (int i = 0; i < 4; i++) {
            int value1 = map.get(arr[i * 2]);
            int value2 = map.get(arr[i * 2 + 1]);

            if (value1 >= value2) {
                sb.append(arr[i * 2]);
            }else{
                sb.append(arr[i * 2 + 1]);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
