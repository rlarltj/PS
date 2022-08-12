package com.company.programmers.test3;

public class Coke {
    public static void main(String[] args) {

        solution(2, 1, 20);

    }

    static int solution(int a, int b, int n) {
        int answer = 0;

        //a개를 가져가면 b개를 받을 수 있다.
        while (true) {
            if (n < a) {
                break;
            }

            int mCoke = (n / a) * b;

            n -= mCoke * a;
            n += mCoke;

            answer += mCoke;

        }

        System.out.println(answer);
        return answer;
    }
}
