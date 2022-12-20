package com.likanug.linkedlist;

public class Test {
    public static void main(String[] args) {
        //构造5个节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        //关联5个节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(node1);
        insert(node1,new ListNode(0));
        System.out.println(node1);
        insert(node3,new ListNode(0));
        System.out.println(node1);
        remove(node2);
        System.out.println(node1);
    }

    //在node1和node2中间插入nodeP
    static void insert(ListNode node1, ListNode nodeP){
        //首先构建
        ListNode node2 = node1.next;
        node1.next = nodeP;
        nodeP.next = node2;
    }

    //删除node1之后的节点
    static void remove(ListNode node1){
        //首先判断链表node1是否只有一个节点
        if(node1.next == null) {
        }else {
            //找到node1的下继节点node2
            ListNode node2 = node1.next;
            //然后找到node2的下继节点node3；
            ListNode node3 = node2.next;
            //删除node1的下一个节点也就是删除node2节点，说白了就是将node1的next指向node3，也就是
            node1.next = node3;
            //这里简化一下代码也就是 node1.next = node2.next //直接把node1的next指针指向node2的next指针
            node2 = null;//释放内存
        }
    }
}
