package com.company.ch3배열;

import java.util.Arrays;
import java.util.Scanner;

public class No10808V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        char[] myChar = st.toCharArray();

        int[] arr = new int[26];
        Arrays.fill(arr, 0);

        for(int i =0; i<myChar.length;i++){
            int num = myChar[i] - 97;
            arr[num]++;
        }

        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
