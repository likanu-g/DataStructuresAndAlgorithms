package com.likanug.sort;

import java.util.Arrays;

public class InsertSort {
    /* 插入排序 */
    static void insertionSort(int[] nums) {
        // 外循环：base = nums[1], nums[2], ..., nums[n-1] ,负责选择元素
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];
            int j = i;
            // 内循环：将 base 插入到左边的正确位置
            while (j > 0 && nums[j-1] > base) {
                nums[j] = nums[j - 1];  // 1. 将 nums[j] 向右移动一位
                j--; //目的是为了比较数组排序好的左侧的数据
                System.out.println("排序的过程：" +Arrays.toString(nums));
            }
            nums[j] = base;         // 2. 将 base 赋值到正确位置
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 1, 5, 2};
        System.out.println("排序前数组：" + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("排序后数组：" + Arrays.toString(nums));
    }
}
