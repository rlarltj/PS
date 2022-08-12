//package com.company.programmers;
//
//import java.util.Stack;
//
//public class check {
//    public static void main(String[] args) {
//    //음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
//    //멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
//    //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
//
//        String s = "ABCDEFG";
//
//        String[] musicInfo = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//        // 1,2 - 7,8      4,5 - 10,11
//        for (int i = 0; i < musicInfo.length; i++) {
//            String s1 = musicInfo[i];
//            int leng = s1.length();
//            int a = Math.abs(s1.charAt(0) - s1.charAt(6));  //10시간 단위
//            int b = Math.abs(s1.charAt(1) - s1.charAt(7));  //1시간 단위
//
//            int c = Math.abs(s1.charAt(3) - s1.charAt(9));  // 10분 단위
//            int d = Math.abs(s1.charAt(4) - s1.charAt(10)); // 1분 단위
//
//            //음악 재생 시간
//            int playTime = a * 60 * 10 + b * 60 + c * 10 + d;
//            StringBuilder sb=  new StringBuilder(s1);
//
//            //음악 반복하기
//            while(sb.length()< playTime){
//            }
//
//            if(playTime/leng >= 1){
//                sb.append(sb);
//            }
////            String ls =
//
//        }
//
//        String[] melody = {};
//
//    }
//}
