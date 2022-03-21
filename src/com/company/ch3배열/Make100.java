package com.company.ch3배열;

public class Make100 {
    public static void main(String[] args) {
        System.out.println(func2(new int[]{1, 52, 48}, 3));
    }

    static int func2(int[] arr, int num) {
        int[] arr2 = new int[101];
        for (int i = 0; i < num; i++) {
            if (arr2[100 - arr[i]] == 1) {
                return 1;
            } else {
                arr2[arr[i]] = 1;       // arr2[52] = 1           }
            }
        }
        return 0;
    }
}
