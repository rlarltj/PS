package com.company;

public class BARK {
    public static void main(String[] args) {
        System.out.println(funcc4(1024));
    }


     int func2(int arr[], int n){
        for(int i =0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] + arr[j] == 100) {
                    return 1;
                }
            }

        }
        return 0;
    }

    static int func3(int n){
        double sqrt = Math.sqrt(n);     // 2.0 3.0 1.134515362
        if((sqrt*sqrt) == n){
            return 1;
        }else{
            return 0;
        }
    }

    static int func4(int n){
        int num = 1;
        for(int i =1; i<=n; i*=2){
            num = i;
        }
        return num;
    }
    static int funcc4(int n){
        int num = 1;

        while(2*num <= n){
            num *= 2;
        }

        return num;
    }
}
