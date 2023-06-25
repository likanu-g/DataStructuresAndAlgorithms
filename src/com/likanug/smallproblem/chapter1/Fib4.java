package com.likanug.smallproblem.chapter1;

public class Fib4 {
    private static  int fib4(int n) {
        int prev = 0, curr = 1;
        for (int i = 0; i < n; i++) {
            int temp = prev;
            prev = curr;
            curr = temp + curr;
            System.out.println("temp = " + temp);
        }
        //返回prev是因为prev包含了n为0，curr比n的结果多了1
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(fib4(5));
        System.out.println(fib4(40));
    }
}