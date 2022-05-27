    package com.company.math;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class No2869 {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            int v = Integer.parseInt(st.nextToken(" "));

            int n = v-b;

            int c = a-b;

            System.out.println(n%c>0? n/c+1 : n/c);
        }
    }
