package com.company.programmers.lv2;

public class FineSquare {
    public static void main(String[] args) {
        System.out.println(solution(8,12));
    }

    public static long solution(int w, int h) {
        long answer = 1;
        long gcd = gcd(w, h);

        answer = (long)w * h - (w + h -gcd);
        return answer;
    }

    static int gcd(int w, int h) {
        int big = Math.max(w, h);
        int small = Math.min(w, h);

        int r = big % small;

        if(r == 0) return small;

        return gcd(small, r);
    }
}
