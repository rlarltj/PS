package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class RepairMan {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken(" "));
        int length = Integer.parseInt(st.nextToken(" "));
        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        Arrays.sort(arr);

//        int location = 0;
        s.push(arr[0]);
        for(int i =0; i<num-1; i++){
            int gap = arr[i+1] - s.peek();
            if(length <= gap){
                s.push(arr[i+1]);
//                location++;
            }else if(length > gap){    // 테이프 길이로 커버 가능한 영역이면
                continue;
            }
        }

        System.out.println(s.size());

    }
}

