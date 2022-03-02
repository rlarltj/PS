package com.company;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
public class Alpha {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
// 한 줄을 입력받는다
        String line = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        // < false , > true로 flag를 지정한다.

        for(int i= 0; i<line.length(); i++){
            if(line.charAt(i) == '<'){
                print(st);
                flag = true;               // <tag>nice<tag>
                System.out.print(line.charAt(i));
            }else if(line.charAt(i) == '>'){
                flag = false;
                System.out.print(line.charAt(i));
            }else if(flag){
                System.out.print(line.charAt(i));
            }

            else{
                if(line.charAt(i) == ' '){
                    print(st);
                    System.out.print(line.charAt(i));
                }else{
                    st.push(line.charAt(i));
                }
            }
        }
        print(st);

    }
    static void print(Stack st){
        while(!st.isEmpty()){
        System.out.print(st.pop());
        };
    }

}
