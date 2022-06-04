package com.company.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        String[] arr = {"U","C","P","C"};

        for (int i = 0; i < 4; i++) {
            String t = arr[i];

            if(sb.indexOf(t) >= 0){
                int idx = sb.indexOf(t);
                sb = sb.delete(0,idx);
            }else{
                System.out.println("I hate UCPC");
                return;
            }
        }

        System.out.println("I love UCPC");
    }
}
