package com.company.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Meeting {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];
        int count = 0;
        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken(" "));
//            시작시간
            arr[i][1] = Integer.parseInt(st.nextToken(" "));
//            종료시간
        }


        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });
        int finTime = 0;
        for(int i =0; i<num; i++){
            if(finTime <= arr[i][0]){
                finTime = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}


