package com.company.greedy;

import java.util.Scanner;

public class AtoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = sc.nextInt();
        int count = 0;

        while(result > n){
            if(result % 2 == 0){
                result /= 2;
                count ++;
            }else if(result % 2 !=0){
                if(result % 10 != 1){
                    System.out.println(-1);
                    return;
                }
               result /= 10;
               count ++;
            }
        }
        if(result % n != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(++count);
    }
}
