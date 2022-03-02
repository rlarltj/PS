package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Intern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum =  Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        for(int k = 0; k<caseNum; k++){


           int num =  Integer.parseInt(br.readLine());
           int person = 1;
           int[][] arr =new int[num][2];
            for(int i =0; i<num; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken(" "));
                arr[i][1] = Integer.parseInt(st.nextToken(" "));
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            int line = arr[0][1];
                for(int i = 1; i<num; i++){
                    if(line > arr[i][1]){

                        line = arr[i][1];
                        person++;
                    }
                }

                sb.append(person).append('\n');

        }
        System.out.println(sb);
        }
}
