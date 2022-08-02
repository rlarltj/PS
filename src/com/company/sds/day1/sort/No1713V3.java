package com.company.sds.day1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1713V3 {
    static int n, m;
    static List<Student> std;
    static Student[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new Student[m+1];
        std = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            list[i] = new Student(i, 0, 0, false);
        }

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken(" "));

            //사진틀에 처음으로 추천되는 경우
            if(list[a] == null){
                list[a] = new Student(a, 0, 0, false);
            }

            //사진틀에 이미 등록된 후보인지
            if(list[a].isIn){
                list[a].recNum++;
            }else{
            //새로 들어가야 하는 후보라면
                if (std.size() < n) {
                //사진틀이 비어있는 경우
                    list[a].isIn = true;
                    list[a].regDate = i;
                    list[a].recNum ++;
                    std.add(list[a]);
                }else{
                //사진틀이 꽉 찬 경우 --> 사진틀에서 한 명을 꺼낸다
                    Collections.sort(std, (o1, o2) -> {
                        if (o1.recNum == o2.recNum) {
                            return o1.regDate - o2.regDate;
                        }
                        return o1.recNum - o2.recNum;
                    });


                    Student delStd = std.remove(0);

                    delStd.recNum = 0;
                    delStd.isIn = false;
                    delStd.regDate = 0;

                    std.add(list[a]);
                    list[a].isIn = true;
                    list[a].regDate = i;
                    list[a].recNum ++;
                }
            }
        }

        Collections.sort(std, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.index - o2.index;
            }
        });

        while (!std.isEmpty()) {
            Student remove = std.remove(0);
            System.out.print(remove.index+" ");
        }


    }


    static class Student {
        int index;
        int regDate;
        int recNum;
        boolean isIn;

        public Student(int index, int regDate, int recNum, boolean isIn) {
            this.index = index;
            this.regDate = regDate;
            this.recNum = recNum;
            this.isIn = isIn;
        }


    }
}
