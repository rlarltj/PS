package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1781 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));  // 데드라인
            int b = Integer.parseInt(st.nextToken(" "));  // 컵라면 개수

            if(map.containsKey(a)){
                map.get(a).add(b);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        Queue<Integer> pq = new PriorityQueue<>();

        for(int deadline: keySet){
            for(int n : map.get(deadline)){
                pq.add(n);
                while(pq.size() > deadline){
                    pq.poll();
                }
            }
        }

        int ans = 0;

        while(!pq.isEmpty()){
            ans += pq.poll();
        }

        System.out.println(ans);


    }
}
