package com.company.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MakeThirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] arr = num.split("");
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            sum+= Integer.parseInt(arr[i]);
        }

        if(!(num.contains("0")) || sum%3 !=0){
            System.out.println(-1);
            return;
        }else{
            Arrays.sort(arr, Comparator.reverseOrder());
        }


        for(String st: arr)
        System.out.print(st);
    }
}
