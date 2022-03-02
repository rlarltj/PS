package com.company.greedy;

import java.util.Scanner;

public class SumOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = sc.nextLong();

        System.out.println(calc(sum));



    }
    public static int calc(long n){
        int sumOfNum = 0;
        int add  = 1;
        int num = 0;

        while(n>=sumOfNum){
            sumOfNum += add++;
        };
        return n == sumOfNum? num : num-1;
    }
}
