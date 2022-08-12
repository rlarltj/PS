//package com.company.programmers;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class StringCompress {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//
//        String[] arr = s.split("");
//
//        int ans = s.length();
//
//        for (int i = 1; i < s.length()/2 + 1; i++) {
//            String prev = s.substring(0, i);
//
//            int count = 1;
//            String s1 = "";
//            String last = "";
//
//            for(int j = i; j< s.length(); j+=i){
//                if(j + i > s.length()){
//                    last = s.substring(j);
//                    continue;
//                }
//
//                if(prev.equals(s1.substring(j, j+i))){
//                    count ++;
//                }else{
//                    s1 =
//                }
//            }
//        }
//    }
//}
