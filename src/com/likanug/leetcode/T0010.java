package com.likanug.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T0010 {
    /*
     输入: 数组 nums [1,2,3,4,5]
     输出：数组 nums1 [120, 60, 40,30, 24]
     解释：num1[i] = num[2] * num[3] * num[4] * num[5]
          输出数组中的第i位为，原数组中非i的其他位 的乘积，乘积小于Integer.Max
    */

    static class Solution1 {
        static int[]  productExceptSelf(int[] nums) {
            //假设是第i位，我们分成i左边和i右边的两部分计算
            int[] result = new int[nums.length];
            //先计算右边。从最后一位往前算
            //初始化初值
            result[nums.length - 1] = 1;
            for (int i = nums.length - 2 ; i >= 0 ; i--) {
                result[i] = result[i + 1] * nums[i + 1];
            }
            //再计算左边，从前往后算
            int left = 1;
            for (int i = 0; i < nums.length; i++) {

                result[i] = left * result[i];
                left = left * nums[i];
            }
            return result;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println("Solution1: " + Arrays.toString(Solution1.productExceptSelf(nums)));
    }
}
