package com.likanug.queue;

import java.util.EmptyStackException;

public class LinkedListQueue {
    ListNode front;
    ListNode rear;
    int length;

    LinkedListQueue() {
        front = null;
        rear = null;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 入队列
     * @param num 入队元素
     */
    public void offer(int num) {
        ListNode node = new ListNode(num);
        //如果队列为空，则头尾节点都是该入队的节点
        if(front == null) {
            front = node;
            rear = node;
        }else {
            rear.next = node;
            //这里的赋值意义同栈的push
            rear = node;
        }
        length++;
    }

    /**
     * 出队列
     * @return 出队列的元素
     */
    public int poll(){
        front = front.next;
        length --;
        return peek();
    }

    /**
     * 查看队首元素
     * @return 队手的元素
     */
    public int peek() {
        if(!isEmpty()){
            return front.val;
        }else{
            throw new EmptyStackException();
        }
    }

}
