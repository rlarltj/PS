package com.company;

import java.util.*;

public class Practice{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "기서");
        map.put(2, "린이");
        map.put(3, "건이");

        Set set = map.entrySet();
        Iterator it2 = set.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

    }

}
