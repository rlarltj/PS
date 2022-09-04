package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
                int count = 0;
                while(num>1){

                    if(num %3 ==1){
                        num = (num-1)/3;
                        count +=2;
                    }else if( num % 3 == 2){
                        if(num%2 ==0){
                            num = num/2;
                            count++;
                        }else{                     //8  4 2 1     7 6 2 1
                            num= (num-2)/3;     //   17 16 8 4 2 1   16 15 5 4 3 1       5 4 2 1  4 3 1   //11         10 5 4 2 1             10 9 3 1
                                    // 36  12   4    3 1
                count+=3;
            }
        }else if(num % 3 ==0){
            num = num/3;
            count++;
        }
        }
        System.out.println(count);

    }
}
