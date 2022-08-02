package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1202 {
    public static void main(String[] args) throws IOException {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken(" "));
        int k = Integer.parseInt(st.nextToken(" "));

        PriorityQueue<Jew> qu = new PriorityQueue<>((o1, o2) -> (o2.price - o1.price));

        int[] bag = new int[k];
        Jew[] jew = new Jew[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gram = Integer.parseInt(st.nextToken(" "));
            int price = Integer.parseInt(st.nextToken(" "));
            jew[i] = new Jew(gram, price);
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);  //가방 오름차순 정렬
        Arrays.sort(jew); // 보석을 무게 기준으로 오름차순 정렬

        for (int i = 0, j=0; i < k; i++) {
            while(j < n && bag[i] >= jew[j].gram){
                qu.offer(jew[j++]);
            }
//
//            if(!qu.isEmpty()){
//                Jew jewr = qu.poll();
//                answer += jewr.price;
//            }
        }

        for (int i = 0; i < k; i++) {
            if(!qu.isEmpty()){
                Jew j = qu.poll();
                answer += j.price;
            }
        }

        System.out.println(answer);
    }
    static class Jew implements Comparable<Jew>{
        int gram;
        int price;

        public Jew(int gram, int price) {
            this.gram = gram;
            this.price = price;
        }

        @Override
        public int compareTo(Jew j) {
            return this.gram - j.gram;
        }
    }
}
