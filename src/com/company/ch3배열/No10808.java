package com.company.ch3배열;

import java.util.Arrays;
import java.util.Scanner;

class No10808{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        char[] myChar = st.toCharArray();

        int[] arr = new int[26];
        Arrays.fill(arr, 0);


        //a p p l e ( 97 . . . .. .)
        for(char a = 'a'; a<= 'z'; a++){
            for(char c: myChar){
                if(a == c){
                    arr[c-97] ++;
                }
            }
        }

        for(int i =0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
        }
    }
}