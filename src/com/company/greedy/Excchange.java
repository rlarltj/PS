package com.company.greedy;

import java.util.Scanner;

public class Excchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int exc = 1000-value;
        int count = 0;
        int[] arr = {500, 100, 50, 10, 5, 1};


            for(int i =0; i<arr.length; i++){

                while(exc>=arr[i]){

                  exc = exc - arr[i];

                  count++;

                  if(exc == 0) break;
                };

            }
        System.out.println(count);
    }
}
