package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class No1927 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        ArrayList<Long> list = new ArrayList<>();
        list.add(0L);
        for (int i = 0; i < num; i++) {
            long a = Integer.parseInt(br.readLine());
            if( a == 0 ) {
//                remove();
            }else{
//                insert();
            }

        }
    }

    static void insert(List<Long> list, long a) {
        list.add(a);
        int idx = list.size() - 1;  // 새로 삽입한 a의 인덱스 정보

        while (idx > 1 && list.get(idx / 2) > list.get(idx)) {
            long tmp = 0L;
            tmp = list.get(idx/2);
            list.set(idx / 2, a);
            list.set(idx, tmp);

            idx /= 2;
        }
    }

    static Long delete(List<Long> list) {
        Long result = list.get(1);
        list.set(1, list.get(list.size()-1));
        list.remove(list.size() - 1);

        int idx = 1;

        while(true){
            Long left = list.get(idx * 2);
            int leftPosition = idx * 2;

            if(leftPosition >= list.size()) break;


        }
        return result;
    }
}
