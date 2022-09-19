package com.company.programmers.lv2;

import java.util.Stack;

public class RotateBracket {
    public static void main(String[] args) {
        String s = "]()[{}";

        solution(s);
    }

    static int solution(String s) {
        int answer = 0;
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            if(isPerfectBracket(s)) answer ++;

            s = s.substring(1) + s.charAt(0);
        }

        System.out.println(answer);
        return answer;
    }

    static boolean isPerfectBracket(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c){
                case '[':
                case '{':
                case '(':
                    st.add(c);
                    break;

                case ']':
                    if(st.isEmpty() || st.peek() != '[') return false;
                    else st.pop();
                    break;

                case '}':
                    if(st.isEmpty() || st.peek() != '{') return false;
                    else st.pop();
                    break;

                case ')':
                    if(st.isEmpty() || st.peek() != '(') return false;
                    else st.pop();
                    break;
            }
        }

        return st.isEmpty();
    }
}
