package com.company.programmers.test1;

import java.util.HashMap;
import java.util.Map;

public class Discount {

    public static void main(String[] args) {
        String[] s = new String[]{"banana", "apple", "rice", "pork", "pot"};
        String[] s2 = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot","banana"
                ,"apple", "banana"};

        int[] num = new int[]{3, 2, 2, 2, 1};

        solution(s, num, s2);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        boolean flag;
        // 첫 날부터 10일씩 할인 품목을 조사한다.
        // 10일에 want 목록이 모두 포함되면 flag = true
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        //map에 구매 목록과 그 개수를 각각 저장한다.

        Map<String, Integer> disMap;
        // i = 4
        for (int i = 0; i < discount.length-10; i++) {
            flag = true;
            disMap= new HashMap<>();
            for (int j = i; j < i+10; j++) {
                if (disMap.get(discount[j]) == null) {
                    disMap.put(discount[j], 1);
                } else{
                    disMap.put(discount[j], Integer.valueOf(disMap.get(discount[j]) + 1));
                }
            }

            for (String s : map.keySet()) {
                if(map.get(s) != disMap.get(s)){
                    flag = false;
                }
            }

            if(flag) answer ++;
        }
        System.out.println(answer);
        return answer;
    }
}
