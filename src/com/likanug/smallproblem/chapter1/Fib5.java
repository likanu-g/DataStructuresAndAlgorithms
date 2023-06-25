package com.likanug.smallproblem.chapter1;

import java.util.stream.IntStream;

public class Fib5 {

    private int prev = 0, curr = 1;

    public IntStream stream() {
        return IntStream.generate(() ->{
            int temp = prev;
            prev = curr;
            curr = temp + prev;
            return prev;
        });
    }

    public static void main(String[] args) {
        Fib5 fib5 = new Fib5();
        fib5.stream().limit(40).forEachOrdered(System.out::println);
    }
}