package com.company.sds.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3955 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken(" "));
            int c = Integer.parseInt(st.nextToken(" "));

            //-KX + CY = 1
            EGResult result = extendedGcd(-k, c);

            if(result.r == 1){
                System.out.println("IMPOSSIBLE");
            }else{
                long t = result.t;

            }

        }
    }

    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long tmp = 0;
        while (r1 != 0) {
            long q = r0/r1;

            tmp = r0 - r1 * q;
            r0 = r1;
            r1 = tmp;

            tmp = t0 - t1 * q;
            t0 = t1;
            t1 = tmp;

            tmp = s0 - s1 * q;
            s0 = s1;
            s1 = tmp;
        }

        return new EGResult(s0, t0, r0);
    }
    static class EGResult{
        long s;
        long t;
        long r;

        public EGResult(long s, long t, long r) {
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }
}
