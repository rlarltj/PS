package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No9009 {
    static ArrayList<Integer> list;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            list = new ArrayList<>();
            answer = new ArrayList<>();

            //한 개의 정수를 입력받는다.
            int n = Integer.parseInt(br.readLine());
            int n1 = 1;
            int n2 = 1;

            while (true) {
                //ArrayList에 피보나치 수열을 담는다.
                //피보나치 수열이 입력받은 정수보다 커지면 break .
                list.add(n1);
                list.add(n2);

                n1 += n2;
                n2 += n1;
                if (n1 > n && n2 > n) break;
            }

            Collections.sort(list, Collections.reverseOrder());
            // 피보나치 수열을 내림차순으로 정렬한다.

            // 입력받은 정수가 0이 될 때 까지 피보나치 수열 중 큰 수부터 차례대로 빼준다.
            // 입력받은 정수보다 큰 수열의 값은 버리고, 빼준 값은 answer에 담은 뒤 출력.
            while (n != 0) {
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k) <= n) {
                        n -= list.get(k);
                        answer.add(list.get(k));
                    }
                }
            }

            Collections.sort(answer);

            for(int ans : answer){
                System.out.print(ans +" ");
            }
            System.out.println();
        }
    }
}
