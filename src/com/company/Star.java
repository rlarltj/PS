package com.company;

import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int v = 1;
// 맨 꼭대기 층
        for(int i = 0; i<num-1; i++)
            System.out.print(" ");
            System.out.println('*');

//  2층 ~ 중간 층
        for(int i=0; i<num-2; i++){
            for(int j = num-i-2; j>0; j--){
                    System.out.print(" ");
            }

            System.out.print('*');

            for(int k = 1; k<=2*i+1; k++){
                System.out.print(" ");

            }
            System.out.println('*');
        }

//        맨 아래층
        if(num !=1){
        for(int i = 0; i< 2*num-1; i++){
            System.out.print('*');
        }
        }
}}
