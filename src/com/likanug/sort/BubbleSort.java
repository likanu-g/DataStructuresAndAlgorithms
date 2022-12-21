package com.likanug.sort;

import java.util.Arrays;

public class BubbleSort {
    /* 冒泡排序 */
    static void bubbleSort(int[] nums) {
        // 外循环：待排序元素数量为 n-1, n-2, ..., 1
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：冒泡操作
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 1, 5, 2};
        System.out.println("排序前数组：" + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("排序后数组：" + Arrays.toString(nums));
    }
}
