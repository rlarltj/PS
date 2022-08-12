package com.company.programmers.lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ReportResultV2 {
    public static void main(String[] args) {
        String[] arr =new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(solution(arr, report, k));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            idxMap.put(id_list[i], i);
            map.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String name = report[i].split(" ")[0];
            String crime = report[i].split(" ")[1];

            map.get(crime).add(name);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> s = map.get(id_list[i]);

            if (s.size() >= k) {
                for (String to : s) {
                    answer[idxMap.get(to)]++;
                }
            }
        }


        return answer;
    }

}
