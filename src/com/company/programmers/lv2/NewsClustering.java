package com.company.programmers.lv2;

import java.util.*;

public class NewsClustering {
    static Set<String> set;
    public static void main(String[] args) {
        solution("FRANCE", "french");
    }

    static int solution(String str1, String str2) {
        int answer = 0;
        String st1 = str1.toLowerCase();
        String st2 = str2.toLowerCase();

        set = new HashSet<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        cluster(st1, map1);
        cluster(st2, map2);
        boolean flag = false;

        Iterator<String> iter = set.iterator();

        int hap = 0;
        int gyo = 0;

        while (iter.hasNext()) {

            String next = iter.next();
            int a= 0, b= 0;

            if (map1.containsKey(next)) {
                a = map1.get(next);
            }
            if (map2.containsKey(next)) {
                b = map2.get(next);
            }
            hap += Math.max(a, b);
            gyo += Math.min(a, b);
        }

        if (hap == 0 && gyo == 0) {
            return answer = 65536;
        }

        answer = (int)(((double)gyo / (double)hap) * 65536);
        return answer;
    }

    static void cluster(String str, Map<String, Integer> map) {
        boolean flag;

        for (int i = 0; i <= str.length() - 2; i++) {
            flag = true;
            String s = str.substring(i, i + 2);

            for (int j = 0; j < 2; j++) {
                if(s.charAt(j) < 'a' || s.charAt(j) >'z'){
                    flag = false;
                    break;
                }
            }

            if(flag){
                set.add(s);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }

}

