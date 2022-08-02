package com.company.sds.day1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1713 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Point> list = new LinkedList<>();
        int[] arr = new int[n+1];
        //comparable

        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken(" "));
            arr[a] ++;
            //1. 사진 틀이 비어있는 경우
            if(list.size()<num){
                if(arr[a] > 0){ //이미 등록된 후보인 경우
                    Point point = list.stream().filter((c) -> c.num == a).findAny().get();
                    point.recNum++;
                }else{ // 새로 추천된 후보인 경우
                    list.add(new Point(a, 1, i));
                }
            }else{
            //2. 사진 틀이 꽉 찬 경우
                //추천 수를 비교한 뒤 삭제.
                if(arr[a] > 0) { //이미 등록된 후보인 경우
                    Point point = list.stream().filter((c) -> c.num == a).findAny().get();
                    point.recNum++;
                    continue;
                }else{

                }
                // 새로운 멤버라면
                Collections.sort(list, new Comparator<Point>() {
                    @Override
                    public int compare(Point o1, Point o2) {
                        if(o1.recNum == o2.recNum){
                            return o1.regDate - o2.regDate;
                        }
                        return o1.recNum - o2.recNum;
                    }
                });

            }



        }
//        [1, 3 , 1, 1, 1, 1, 1]
        //정답 출력은 comparator

    }

    static class Point{
        int num; // 인덱스 번호
        int recNum; // 추천 수
        int regDate; // 등록 일
        public Point(int num, int recNum) {
            this.num = num;
            this.recNum = recNum;
        }

        public Point(int num, int recNum, int regDate) {
            this.num = num;
            this.recNum = recNum;
            this.regDate = regDate;
        }
    }
}
