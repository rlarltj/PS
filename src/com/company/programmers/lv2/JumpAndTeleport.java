package com.company.programmers.lv2;

public class JumpAndTeleport {
    public static void main(String[] args) {
        solution(5000);
    }
    public static int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else{
                n /= 2;
                ans ++;
            }
        }

        return ans;
    }
}
