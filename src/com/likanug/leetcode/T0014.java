package com.likanug.leetcode;

public class T0014 {
    /*
     数组的子数列，相邻元素的和等于某个值得的个数,如果没有，则返回0
     例如 int[] nums = {1,1,1}
          计算和等于2的子数列的个数
          个数为2，num[0],num[1]以及num[1]、num[2]
    */

    static class Solution1 {

        public int subArraySum(int[] nums, int k) {
            int count = 0;
            //也就是计算num[i] + num[i+1] +...+ num[j] = k
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int sum = 0;
                    for (int l = i; l <= j; l++) {
                        sum += nums[l];
                    }
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }

    }


    static class Solution2 {

        public int subArraySum(int[] nums, int k) {
            int count = 0;
            //也就是第一轮：计算num[0] + num[1] = k
            //也就是第二轮：计算num[0] + num[1] + num[2] = k
            //也就是第三轮：计算num[0] + num[1] + num[2] + num[3] = k
            //也就是第四轮：计算num[0] + num[1] + num[2] + num[3] + num[4]= k
            //......
            //......
            //也就是第n轮：计算num[0] + num[1] + num[2] + num[3] +......+ num[n]= k
            //简化计算，第一轮：令sum = num[0] + num[1] = k,则
            //        第二轮：第一轮的sum + num[2] = k
            //        第三轮：第二轮的sum + num[3] = k
            //        第四轮：第三轮的sum + num[4] = k
            //依次类推：第n轮，等于 第n-1轮的sum + num[n] = k ，代码如下
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (k == sum) {
                        count++;
                    }
                }
            }
            return count;
        }
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {1, 1, 1, 1};
        System.out.println(solution1.subArraySum(nums, 2));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.subArraySum(nums, 2));

    }
}
