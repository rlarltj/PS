package com.company.programmers.lv1;

import java.util.*;

public class ReportResult {
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
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
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
