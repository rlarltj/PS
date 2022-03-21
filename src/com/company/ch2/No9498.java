package com.company.ch2;

import java.util.Scanner;

public class No9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        switch(i/10){
            case 10: case 9:
                System.out.println("A");
                break;
                case 8:
                System.out.println("B");
                    break;
            case 7:

                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;

            default:
                System.out.println("F");
        }
    }
}
