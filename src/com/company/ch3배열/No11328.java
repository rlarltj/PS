package com.company.ch3배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11328 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Loop1: for (int i = 0; i < num; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
            String before = st.nextToken(" ");
            String after = st.nextToken(" ");

            String[] arr1 = before.split("");
            String[] arr2 = after.split("");
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if(arr1.length != arr2.length){
                sb.append("Impossible").append('\n');
                continue ;
            }
            for(int j = 0; j<arr1.length; j++){
                if(arr1[j].equals(arr2[j])){
                    continue;
                }else{
                    sb.append("Impossible").append('\n');
                    continue Loop1;
                }
            }
            sb.append("Possible").append('\n');
        }

        System.out.println(sb);

    }
}
