package com.company.sds.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2143 {
    static long num;
    static int n, m;
    static long[] mArr, nArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Long.parseLong(br.readLine());
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nArr = new long[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = Long.parseLong(st.nextToken(" "));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        mArr = new long[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = Long.parseLong(st.nextToken(" "));
        }

        //subA, subB
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
            long dist = 0;
            for (int j = i; j < m; j++) {
                dist += mArr[j];
                subB.add(dist);
            }
        }

        //정렬

        Collections.sort(subA);
        Collections.sort(subB, Collections.reverseOrder());

        //투포인터

        long result = 0;
        int ptA = 0;
        int ptB = 0;

        while (true) {
            long currentA = subA.get(ptA);
            long target = num - currentA;

            if (subB.get(ptB) == target) {
                //같은 경우, 동일한 수가 몇 개 있는지 구해야 한다.
                long countA = 0;
                long countB = 0;

                while(ptA < subA.size() && subA.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }

                while(ptB < subB.size() && subB.get(ptB) == target){
                    countB++;
                    ptB++;
                }

                result += countA * countB;
            } else if (subB.get(ptB) < target) {
                ptA++;
            } else{
                ptB++;

            }

            if (ptA == subA.size() || ptB == subB.size()) {
                break;
            }
        }

        System.out.println(result);
    }
}
