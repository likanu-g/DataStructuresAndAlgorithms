package com.likanug.stack;

import java.util.ArrayList;

public class ArrayStack {
    ArrayList<Integer> stack;

    ArrayStack(){
        stack = new ArrayList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void push(int num) {
        stack.add(num);
    }

    public int pop(){
        //ArrayList的remove方法会返回remove的元素
        return stack.remove(size() - 1);
    }

    public int peek() {
        return stack.get(size() - 1);
    }
}
