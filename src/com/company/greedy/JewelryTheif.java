package com.company.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JewelryTheif {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfJew = Integer.parseInt(st.nextToken(" "));
        int numOfBag = Integer.parseInt(st.nextToken(" "));
        int [][] arr = new int[numOfJew][2];
        for(int i = 0 ; i< numOfJew; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken(" "));
            //[무게] [가격]
            //[무게] [가격]
            arr[i][1] = Integer.parseInt(st.nextToken(" "));
        }
        Integer[] bagArr = new Integer[numOfBag];
        for(int i =0; i< numOfBag; i++){
            st = new StringTokenizer(br.readLine());

            bagArr[i] = Integer.parseInt(st.nextToken(" "));
        }

        // 1. 가방 용량이 큰 순으로 정렬한다.
//        2. 용량 허용범위 내에 있는 보석 중 가치가 가장 높은 보석을 선택한다.
//        3. 해당 보석의 가치를 합한 후 출력한다.

        Arrays.sort(bagArr, Comparator.reverseOrder());

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){  // value가 높은 순으로 정렬하며, value가 같은 경우에는 무게가  가벼운 순으로 정렬
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });


    }
}
