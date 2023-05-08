package com.likanug.leetcode;

import java.util.HashMap;
import java.util.Map;

public class T0001 {

    /*
     输入：nums = [2,7,11,15], target = 9
     输出：[0,1]
     解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    class Solution {

        public int[] twoSum(int nums[], int target) {
            Map<Integer, Integer> map = new HashMap<>();
            //首先遍历整个数组
            for (int i = 0; i < nums.length; i++) {
                //拿到数组的值
                int tmp = nums[i];
                //计算另一个数的大小
                int rest = target - tmp;
                //比较放入map中的值
                if(map.containsKey(rest)){ //
                    return new int[]{tmp,map.get(rest)};
                }else {

                }
                //将数组中元素放入HashMap中
                map.put(tmp,i);
            }
            return null;
        }
    }
}
