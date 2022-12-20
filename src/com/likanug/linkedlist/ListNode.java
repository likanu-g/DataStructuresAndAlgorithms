package com.likanug.linkedlist;

import java.util.StringJoiner;

public class ListNode {
    int val;
    ListNode next;

     ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("next=" + next)
                .toString();
    }
}
