package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AutoExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int exchange = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
             exchange = Integer.parseInt(br.readLine());
             int a = 0;
             int b = 0;
             int c = 0;
             int d = 0;

            while(exchange>0){
                if(exchange>=25){
                    a = exchange/25;
                    exchange -= 25*a;
                }else if(exchange >=10){
                    b = exchange/10;
                    exchange -= b* 10;
                }else if(exchange >= 5){
                    c = exchange / 5;
                    exchange -= c*5;
                }else{
                    d = exchange;
                    break;
                }
            }
            sb.append(a+" "+b+" "+c+" "+d).append('\n');
        }
        System.out.println(sb);
    }

}
