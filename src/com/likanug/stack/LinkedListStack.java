package com.likanug.stack;

import java.util.EmptyStackException;

public class LinkedListStack {
    ListNode stackPeek;
    int stackHeight;

    LinkedListStack(){
        this.stackPeek = null;
    }

    public int size() {
        return stackHeight;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 入栈（向栈顶添加元素）
     * @param num 数字
     */
    public void push(int num) {
        ListNode nodeTmp = new ListNode(num);
        nodeTmp.next = stackPeek;//此时nodeTmp变成新栈，
        // 注意这里要把nodeTmp赋值给stackPeek，其实可以直接返回nodeTmp,
        // 但是我们是void方法,没有返回值，所以只能把nodeTmp赋值给stackPeek作为全局变量返回
        stackPeek = nodeTmp;
        stackHeight ++;
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stackHeight --;
        return num;
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    public int peek() {
        if(!isEmpty()) {
            return stackPeek.val;
        }else {
            throw new EmptyStackException();
        }

    }
}
