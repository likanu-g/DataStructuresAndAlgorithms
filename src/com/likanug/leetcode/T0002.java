package com.likanug.leetcode;

public class T0002 {
    /*
     输入：nums = [0,2,7,0,11,15]
     输出：nums = [2,7,11,15,0,0]
     解释：把数组中的0，移动到数组的最右边，不改变其他非0数字的顺序
    */
    class Solution {
        void moveZeros(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                //num 不等于 0 放左边
                if(nums[i] != 0) {
                    //这里不用担心j会把原数组的值覆盖掉，应为j 永远<= i
                    nums[j] = nums[i];
                    j ++;
                }
            }
            //剩余的数字全部赋值为0
            while (j < nums.length) {
                nums[j] = 0;
                j ++;
            }
        }
    }
}
