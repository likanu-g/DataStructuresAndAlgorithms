package com.likanug.leetcode;

import java.util.Stack;
import java.util.StringJoiner;

public class T0008 {
    /*
     输入:一个二叉树
            3
           /  \
          9    20
         /    /  \
        5    15   7
            /
           17

     输出：4
     解释：求树的最大高度
    */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    static int maxDepth(TreeNode tree) {
        //树的最大高高度就是左子树和右子树的最大高度 + 1
        if(tree == null) {
            return 0;
        }else {
            int leftDepth = maxDepth(tree.left);
            int rightDepth = maxDepth(tree.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode();
        tree.val = 3;
        tree.left = new TreeNode();
        tree.right = new TreeNode();
        tree.left.val = 9;
        tree.right.val = 20;
        tree.left.left = new TreeNode();
        tree.left.left.val = 5;
        tree.right.left = new TreeNode();
        tree.right.right = new TreeNode();
        tree.right.left.val = 15;
        tree.right.right.val = 7;
        tree.right.left.left = new TreeNode();
        tree.right.left.left.val = 17;
        System.out.println(maxDepth(tree));
    }
}
