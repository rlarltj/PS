package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2143V3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken(" "));
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken(" "));
        }

        //부배열 만들기
        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long dist = nArr[i];
            subA.add(dist);
            for (int j = i + 1; j < n; j++) {
                dist += nArr[j];
                subA.add(dist);
            }
        }


        for (int i = 0; i < m; i++) {
            long dist = mArr[i];
            subB.add(dist);
            for (int j = i + 1; j < m; j++) {
                dist += mArr[j];
                subB.add(dist);
            }
        }


        //투 포인터
        Collections.sort(subA); // 오름차순 정렬
        Collections.sort(subB, Comparator.reverseOrder()); // 내림차순 정렬

        int ptA = 0;
        int ptB = 0;
        long result = 0;
        long answer = 0;
        while (true) {
            long a = subA.get(ptA);
            long b = subB.get(ptB);
            result = a + b;

            //두 합이 t와 같은 경우  --> 뒤에 중복되는 숫자의 개수를 구해야 한다.
            if(result == t){
                long countA = 0;
                long countB = 0;

                while (ptA < subA.size() && subA.get(ptA) == a) {
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == b) {
                    countB++;
                    ptB++;
                }

                answer += countA * countB;
            }
            //두 합이 t보다 작은 경우 --> subA의 커서를 한 칸 뒤로
            else if(result < t){
                ptA++;
            }else if(result > t){
            //두 합이 t보다 큰 경우 --> subB의 커서를 한 칸 뒤로
                ptB++;
            }

            //ptA, ptB 중 하나라도 범위를 넘어가는 경우 종료한다.
            if (ptA >= subA.size() || ptB >= subB.size()) {
                break;
            }
        }
        System.out.println(answer);
    }
}
