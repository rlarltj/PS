import java.util.*;
import static java.util.Collections.frequency;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int length = minerals.length % 5 == 0 ? minerals.length / 5 : minerals.length / 5 + 1;

        List<List<String>> mineralList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            mineralList.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0 + i * 5; j < 5 + i * 5; j++) {
                if (j >= minerals.length) break;
                mineralList.get(i).add(minerals[j]);
            }
        }
        
        int numOfPicks = picks[0] + picks[1] + picks[2];

        if (numOfPicks < length) {
            int removeCount = length - numOfPicks;

            for (int i = 0; i < removeCount; i++) {
                mineralList.remove(mineralList.size() - 1);
            }
        }

        
        Collections.sort(mineralList, (l1, l2) -> {
            if (frequency(l2, "diamond") == frequency(l1, "diamond")) {
                if (frequency(l2, "iron") == frequency(l1, "iron")) {
                    return frequency(l2, "stone") - frequency(l1, "stone");
                } else {
                    return frequency(l2, "iron") - frequency(l1, "iron");
                }
            } else {
                return frequency(l2, "diamond") - frequency(l1, "diamond");
            }
        });

        for (int i = 0; i < picks[0]; i++) {
            if (mineralList.isEmpty()) break;
            List<String> curL = mineralList.get(0);
            for (int j = 0; j < curL.size(); j++) {
                answer += 1;
            }
            mineralList.remove(0);
        }
        
        for (int i = 0; i < picks[1]; i++) {
            if (mineralList.isEmpty()) break;
            List<String> curL = mineralList.get(0);
            for (int j = 0; j < curL.size(); j++) {
                if (curL.get(j).equals("diamond")) answer += 5;
                else answer += 1;
            }
            mineralList.remove(0);
        }

        // 돌 곡괭이로 채광
        for (int i = 0; i < picks[2]; i++) {
            if (mineralList.isEmpty()) break;
            List<String> curL = mineralList.get(0);
            for (int j = 0; j < curL.size(); j++) {
                if (curL.get(j).equals("diamond")) answer += 25;
                else if (curL.get(j).equals("iron")) answer += 5;
                else answer += 1;
            }
            mineralList.remove(0);
        }

        return answer;
    }
}