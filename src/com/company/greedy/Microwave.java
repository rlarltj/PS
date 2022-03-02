package com.company.greedy;
import java.util.*;
public class Microwave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] arr = {300, 60, 10};
        int[] countArr ={0,0,0};


        if(num % arr[2] != 0){
                System.out.println(-1);
                return;
        }


        for(int i = 0; i<arr.length; i++){
            while(num >= arr[i]){
                num -= arr[i];
                countArr[i]++;
            }
        }

        for(int i =0; i<countArr.length; i++){
            System.out.print(countArr[i]+" ");
        }
    }
}
