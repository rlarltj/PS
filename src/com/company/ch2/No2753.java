package com.company.ch2;

import java.util.Scanner;

public class No2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        func(i);
    }

    private static int func(int i) {
        return (i % 4) == 0 ? (i%100 == 0 ? (i%400==0? 1:0) : 1 ) : 0;
    }
}
