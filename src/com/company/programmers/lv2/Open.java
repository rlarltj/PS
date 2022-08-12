package com.company.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Open {
    public static void main(String[] args) {
        String[] arr = {"Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"};

        solution(arr);



    }

    static String[] solution(String[] record) {

//        "Prodo님이 들어왔습니다.",
//        "Ryan님이 들어왔습니다.",
//        "Prodo님이 나갔습니다.",
//        "Prodo님이 들어왔습니다."

        Map<String, String> map = new HashMap<>();
        String comm, id, name;
        for (int i = 0; i < record.length; i++) {
            comm = record[i].split(" ")[0];
            id = record[i].split(" ")[1];


            if(comm.equals("Enter") || comm.equals("Change")){
                name = record[i].split(" ")[2];
                map.put(id, name);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            comm = record[i].split(" ")[0];
            id = record[i].split(" ")[1];

            name = map.get(id);

            String action = "";
            if(comm.equals("Enter")){
                action += "님이 들어왔습니다.";
            }else if(comm.equals("Leave")){
                action += "님이 나갔습니다.";
            }else {
                continue;
            }

            list.add(name+action);
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
