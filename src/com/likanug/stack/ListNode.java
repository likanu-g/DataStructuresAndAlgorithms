package com.likanug.stack;

import java.util.StringJoiner;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
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
