package com.company.ch10Recursive;

import java.math.BigInteger;
import java.util.Scanner;

public class No1914 {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sb = new StringBuilder();

        if(n<=20){
            sb.append((int)Math.pow(2, n)- 1).append('\n');
            Hanoi(n, 1 ,2 ,3);
        }else{

            BigInteger b = new BigInteger("1");
            for(int i =0; i<n; i++){
                b = b.multiply(new BigInteger("2"));
            }
            b = b.subtract(new BigInteger("1"));
            sb.append(b).append('\n');
        }
        System.out.println(sb);

    }

    private static void Hanoi(int n, int start, int mid, int to) {

        if(n == 1){
            sb.append(start + " "+ to+'\n');
            return;
        }

        Hanoi(n-1 , start, to , mid);

        sb.append(start + " " + to + '\n');

        Hanoi(n-1, mid, start , to);
    }
}
