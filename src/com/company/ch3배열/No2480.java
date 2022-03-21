package com.company.ch3배열;

import java.util.Scanner;

public class No2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a==b && a==c){
            //셋 다 일치
            System.out.println(10000+a*1000);
        }else if(a == b || a == c){
            //두개가 일치
            System.out.println(1000+a*100);
        }else if(b==c){
            System.out.println(1000+b*100);
        }else{
            int max = Math.max(c, Math.max(a, b));
            System.out.println(max*100);
        }

    }
}
