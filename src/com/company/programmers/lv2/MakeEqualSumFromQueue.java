package com.company.programmers.lv2;

public class MakeEqualSumFromQueue {
    public static void main(String[] args) {
        int[] a1 = {1, 1};
        int[] a2 = {1, 5};

        solution(a1, a2);
    }

    static int solution(int[] queue1, int[] queue2) {

        int length1 = queue1.length;
        int length2 = queue2.length;

        long sum1 = 0;
        long sum2 = 0;

        int[] arr = new int[(length1 + length2) * 2];
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
        }
        int idx = 0;
        int end = 0;
        long bigSum = Math.max(sum1, sum2);
        if (sum1 > sum2) {
            for (int i = 0; i < queue1.length; i++) {
                arr[idx++] = queue1[i];
            }
            end = idx - 1;
            for (int i = 0; i < queue2.length; i++) {
                arr[idx++] = queue2[i];
            }

        }else{
            for (int i = 0; i < queue2.length; i++) {
                arr[idx++] = queue2[i];
            }
            end = idx - 1;

            for (int i = 0; i < queue1.length; i++) {
                arr[idx++] = queue1[i];
            }
        }


        int start = 0;
        int count = 0;
        long same = (sum1 + sum2) / 2;
        while (true) {
            if (bigSum == same) {
                break;
            }

            if(bigSum > same){
                bigSum -= arr[start];
                arr[idx++] = arr[start++];
                count++;
            }else{
                end ++;
                bigSum += arr[end];
                count++;
            }


            if (idx == arr.length) {
                return -1;
            }
        }


        return count;
    }
}
