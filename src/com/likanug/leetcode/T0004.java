package com.likanug.leetcode;

import java.util.Arrays;

public class T0004 {
    /*
     输入：[7,1,5,3,6,4]
     输出：3
     解释：计算数组中各个元素+1后的值还是数组中
    */
    static class Solution1 {
        //使用排序的方法
        int countElements(int[] array) {
            Arrays.sort(array);
            //符合条件的元素个数
            int count = 0;
            //元素值相同的元素个数
            int number = 1;
            for (int i = 1; i < array.length; i++) {
                //如果发现数组中前后两个元素的值不相等
                if(array[i] != array[i-1]){
                    //且后一个值 等于 前一个值 + 1， 说明该元素满足条件
                    if(array[i] == array[i-1] + 1){
                        count += number;
                    }
                    // 重置 number
                    number = 1;
                }else {
                    number ++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            Solution1 solution1 = new Solution1();
            int countElements = solution1.countElements(new int[]{7, 1, 5, 3, 6, 4});
            System.out.println("countElements1 = " + countElements);

        }
    }

    static class Solution2 {

        //使用辅助数组的方法
        int countElements(int[] array) {
            int count = 0;
            //定义辅助数组，规定数组数字范围为0~100
            boolean[] found = new boolean[100];
            //将数组中所有元素的标注在辅助数组中
            for (int k : array) {
                found[k] = true;
            }
            for (int j : array) {
                //判断 array[i] + 1是否在辅助数组中
                if (found[j + 1]) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {

            Solution2 solution2 = new Solution2();
            int countElements = solution2.countElements(new int[]{7, 1, 5, 3, 6, 4});
            System.out.println("countElements2 = " + countElements);

        }
    }

}
