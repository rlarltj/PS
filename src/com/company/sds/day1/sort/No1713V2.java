package com.company.sds.day1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1713V2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        Student[] arr = new Student[101];

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken(" "));
            //최초로 추천된 경우
            if (arr[k] == null) {
                arr[k] = new Student(k, 0, 0, false);
            }

            //사진틀에 후보가 있는 경우
            if(arr[k].isIn == true){
                arr[k].recNum++;
            }else{
                //사진틀에 후보가 없는 경우
                if (list.size() == num) {
                    //사진틀이 가득 찬 경우
                    // 정렬, 지울 후보 선정, 제거
                    Collections.sort(list, (o1, o2) -> {
                        if (o1.recNum == o2.recNum) {
                            return o1.regDate - o2.regDate;
                        }
                        return o1.recNum - o2.recNum;
                    });
                    Student remove = list.remove(0);
                    remove.isIn = false;
                }
                    arr[k].isIn = true;
                    arr[k].recNum = 1;
                    arr[k].regDate = k;
                    list.add(arr[k]);

                }
            }

        Collections.sort(list, (o1, o2) -> o1.index - o2.index);

        while (!list.isEmpty()) {
            Student remove = list.remove(0);
            sb.append(remove.index+" ");
        }

        System.out.println(sb);
    }

    static class Student {
        int index;
        int recNum;
        int regDate;
        boolean isIn;

        public Student(int index, int recNum, int regDate, boolean isIn) {
            this.index = index;
            this.recNum = recNum;
            this.regDate = regDate;
            this.isIn = isIn;
        }
    }
}
