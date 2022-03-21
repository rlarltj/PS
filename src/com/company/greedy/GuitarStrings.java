package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            st= new StringTokenizer(br.readLine());
        int stringNum = Integer.parseInt(st.nextToken(" "));
        int brandNum = Integer.parseInt(st.nextToken(" "));
        int[] packArr = new int[brandNum];
        int[] pieceArr = new int[brandNum];
        for(int i =0; i<brandNum; i++){
            st= new StringTokenizer(br.readLine());
            packArr[i] = Integer.parseInt(st.nextToken());
            pieceArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packArr);
        Arrays.sort(pieceArr);
        int packPrice = packArr[0];
        int piecePrice = pieceArr[0];
        int price = 0;
        while(stringNum>0){
            if(stringNum >= 6){
                if(packPrice > piecePrice*6){
                    price += piecePrice*6;
                    stringNum -= 6;
                }else{
                    price += packPrice;
                    stringNum -= 6;
                }
            }else{
                if(packPrice > stringNum * piecePrice){
                    price += stringNum * piecePrice;
                    stringNum = 0;
                }else{
                    price += packPrice;
                    stringNum = 0;
                }
            }

        }
        System.out.println(price);
    }
}
