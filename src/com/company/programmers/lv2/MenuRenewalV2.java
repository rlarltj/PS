package com.company.programmers.lv2;

import java.util.*;

public class MenuRenewalV2 {
    static List<String> list;
    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        solution(orders, course);

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        list = new ArrayList<>();
        //코스 메뉴조합의 모든 경우의 수 구하기 (dfs)
        for(int i=0; i<orders.length; i++) {
            String[] one = orders[i].split("");
            Arrays.sort(one);

            for(int j=0; j< one.length-1; j++) {
                for(int k=0; k< course.length; k++) {
                    dfs(one, j, 1, course[k], one[j]);
                }
            }
        }

        Map<String , Integer> map = new HashMap<>();
        for(String menu : list) {
            map.put(menu, map.getOrDefault(menu, 0)+1);
        }


        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)-map.get(o1);
            }
        });


        List<String> res = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max = 0;

            // course 갯수별로 가장 인기있는 품목 선정
            for (String courseMenu : list) {
                if (map.get(courseMenu) > 1 && courseMenu.length() == course[i]) {
                    if (map.get(courseMenu) >= max) {
                        res.add(courseMenu);
                        max = map.get(courseMenu);
                    }
                }
            }
        }

        // 문자순 정렬
        Collections.sort(res);

        answer = new String[res.size()];
        res.toArray(answer);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }


    static void dfs(String[] one, int idx, int len, int courseLen, String str) {
        if(len == courseLen) {
            list.add(str);
        }

        for(int i= idx+1; i<one.length; i++) {
            dfs(one, i, len+1, courseLen, str+one[i]);
        }
    }
}