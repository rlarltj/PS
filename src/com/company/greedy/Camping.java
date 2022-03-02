package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int[] arr = new int[3];
        int count = 0;
        while(true){
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if(arr[0] == 0 && arr[1] == 0 &&arr[2] == 0) break;

            int sum = (arr[2]/arr[1]) * arr[0] + (arr[2] % arr[1] > arr[0]? arr[0]: arr[2]%arr[1]);
            count ++;
            sb.append("Case " + count + ": "+sum).append('\n');
// 9 11 20
        }
        System.out.println(sb);
    }
}
