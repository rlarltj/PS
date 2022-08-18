package com.company.programmers.lv2;

import java.util.*;

public class MenuRenewal {
    static List<String> list;
    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        solution(orders, course);

    }

    static String[] solution(String[] orders, int[] course) {
        String[] result = {};
        list = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            String[] one = orders[i].split("");
            Arrays.sort(one);

            for (int j = 0; j < one.length - 1; j++) {
                for (int k = 0; k < course.length; k++) {
                    dfs(one, j, k, course[k], one[j]);
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (String menu : list) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        Collections.sort(keyList, (o1, o2) -> map.get(o1) - map.get(o2));

        List<String> res = new ArrayList<>();
        for(int i=0; i< course.length; i++) {
            int max =0;

            // course 갯수별로 가장 인기있는 품목 선정
            for(String courseMenu : list) {
                if(map.get(courseMenu)>1 && courseMenu.length() == course[i]) {
                    if(map.get(courseMenu) >= max) {
                        res.add(courseMenu);
                        max = map.get(courseMenu);
                    }
                }
            }
        }

        Collections.sort(res);

        result = new String[res.size()];
        res.toArray(result);


        return result;
    }

    private static void dfs(String[] one, int idx, int len, int courseLen, String str) {
        if (len == courseLen) {
            list.add(str);
        }

        for (int i = idx + 1; i < one.length; i++) {
            dfs(one, i, len + 1, courseLen, str+one[i]);
        }
    }
}
