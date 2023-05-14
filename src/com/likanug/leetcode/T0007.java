package com.likanug.leetcode;

import java.util.Stack;
import java.util.StringJoiner;

public class T0007 {
    /*
     输入：设计一个堆栈，它有一个方法可以返回堆栈的最小值
        [ 2，1，3，2，5]
     输出：1
     解释：输出栈的最小值
    */

    static class MinStack{
        Stack<Integer> data = new Stack<>();
        Stack<Integer> min = new Stack<>();

        void push(Integer integer) {
            data.push(integer);
            if(min.isEmpty()) {
                min.push(integer);
            }else {
                if (integer > min.peek()) {
                    min.push(min.peek());
                }else {
                    min.push(integer);
                }
            }
        }

        void pop() {
            data.pop();
            min.pop();
        }

        Integer getMin() {
            return min.peek();
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", MinStack.class.getSimpleName() + "[", "")
                    .add("data=" + data)
                    .toString();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        System.out.println("minStack = " + minStack);
        System.out.println("min = " + minStack.getMin());
    }
}
