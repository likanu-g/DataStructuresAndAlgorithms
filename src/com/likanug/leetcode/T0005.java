package com.likanug.leetcode;

public class T0005 {
    /*
     输入：[7,1,5,3,6,4]
     输出：[3,6,4]
     解释：找出链表中间的节点
    */

    static final class ListNode {
        int val;
        ListNode next;
    }

    static class Solution1 {

        ListNode middleNode(ListNode head) {
            //使用双指针
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null){
                //fast 节点每次走两步
                fast = fast.next.next;
                //slow 节点每次走一步
                slow = slow.next;
            }
            return slow;
        }

        void printNode(ListNode node) {
            StringBuilder stringBuilder = new StringBuilder();
            //遍历到倒数第二个节点
            while (node.next != null) {
                stringBuilder.append(node.val).append(" -> ");
                node = node.next;
            }
            //最后一个节点 单独追加
            stringBuilder.append(node.val);
            System.out.println("stringBuilder = " + stringBuilder);
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        //初始化链表
        node.val = 7;
        node.next = new ListNode();
        node.next.val = 1;
        node.next.next = new ListNode();
        node.next.next.val = 5;
        node.next.next.next = new ListNode();
        node.next.next.next.val = 3;
        node.next.next.next.next = new ListNode();
        node.next.next.next.next.val = 6;
        node.next.next.next.next.next= new ListNode();
        node.next.next.next.next.next.val = 4;
        node.next.next.next.next.next.next= new ListNode();
        node.next.next.next.next.next.next.val = 0;
        Solution1 solution1 = new Solution1();
        solution1.printNode(solution1.middleNode(node));
    }
}
