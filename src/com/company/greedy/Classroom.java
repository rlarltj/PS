package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Classroom {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[num][2];

        for(int i =0; i<num; i++){
             st = new StringTokenizer(br.readLine());
             arr[i][0] = Integer.parseInt(st.nextToken(" "));
             arr[i][1] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1]-o2[1];

                return o1[0] - o2[0];
            }
        });
        // 시작 시간이 빠른 순으로 정렬하였다.
        // 시작 시간이 같은 경우 끝나는 시간이 빠른 순으로 정렬하였다.
//        System.out.println(Arrays.deepToString(arr));


        // 수업 시작 시간인데, 다른 수업중이면 강의실이 추가되어야 한다.

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        qu.offer(arr[0][1]);

        for (int i = 1; i < num; i++) {
            if(qu.peek() <= arr[i][0]){
                qu.poll();
            }
            qu.offer(arr[i][1]);
        }

        System.out.println(qu.size());
    }
}
