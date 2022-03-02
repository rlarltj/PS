package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OilStation {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cityNum = Integer.parseInt(br.readLine());
    int[] distance = new int[cityNum-1];
    int[] oilPrice = new int[cityNum];
    int cost = 0;

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
    for(int i = 0; i<distance.length; i++){
        distance[i] = Integer.parseInt(st.nextToken(" "));
    }
        st = new StringTokenizer(br.readLine());
    for(int i = 0; i< cityNum; i++){
        oilPrice[i] = Integer.parseInt(st.nextToken(" "));
    }

    for(int i= 0; i< oilPrice.length-1; i++){
        if(oilPrice[i] < oilPrice[i+1]){
//            다음 집이 비싼경우, 다음 집 기름 가격을 싼집 가격으로 바꿔버린다.
            oilPrice[i+1] = oilPrice[i];
        }
    }
    for(int i =0; i<distance.length; i++){
        cost += distance[i] * oilPrice[i];
    }
        System.out.println(cost);


//        기름 가격을 비교한다. 첫 도시에서는 최저가가 아니어도 다음 마을까지는 가야하므로 무조건 주유함.
//        1번 2번 비교 ==> 1번이 더 싼 경우 1번 3번 비교 ==> 3번이 더 싼 경우 3번 4번 비교
//        이후 첫 도시를 포함해 최저가 주유소에서 풀충전 한다.

    }

}
