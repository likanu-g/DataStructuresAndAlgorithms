package com.likanug.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T0009 {
    /*
     输入: 数组[0,1,0,0,0,1,1,1,0,1,0]
     输出：10
     解释：找出数组中0和1个数相等的数字相邻的子串长度
     例如 [0,1] ,为2
    */

    static class Solution1 {
        static int  findMaxLength(int[] nums) {
            //计算包含0的个数count0 从0数到i <= nums位
            //计算包含1的个数count1 从i数到j <= nums位
            //比较 count0和count1的大小，如果相等最大长度就是j - 1 + 1
            int maxLength = 0;
            for (int i = 0; i < nums.length; i++) {
                //j 从 i的后一位数
                for (int j = i + 1; j < nums.length; j++) {
                    int count0 = 0;
                    int count1 = 0;

                    for (int k = i; k <= j; k++) {
                        //因为不是0就是1
                        if(nums[k] == 0) {
                            count0 ++;
                        }else {
                            count1 ++;
                        }
                    }
                    if(count0 == count1) {
                        int length = j - i + 1;
                        maxLength = Math.max(maxLength, length);
                    }
                }
            }
            return maxLength;
        }
    }

    static class Solution2 {
        static int  findMaxLength(int[] nums) {
            int countDiffSize = nums.length + 1;
            int[] countDiff = new int[countDiffSize];
            countDiff[cIndex(-1)] = 0;
            for (int i = 0; i < nums.length; i++) {
                countDiff[cIndex(i)] =
                        nums[i] == 0 ? countDiff[cIndex(i - 1)] + 1
                                : countDiff[cIndex(i - 1)] - 1;
            }
            int findMaxSize = 2 * nums.length + 1;
            int[] findMax = new int[findMaxSize];
            //初始化求和数组所有元素全部为 -1
            for (int i = - nums.length; i <= nums.length ; i++) {
                findMax[findIndex(i, nums.length)] = -1;
            }
            //后半部分初始化为数组索引大小
            for (int i = 0; i < nums.length; i++) {
                findMax[findIndex(i, nums.length)] = i;
            }
            int maxLength = 0;
            //遍历数组
            for (int i = 0; i < nums.length; i++) {
                int target = countDiff[cIndex(i)];
                int length = findMax[findIndex(target, nums.length)] - i + 1;
                maxLength = Math.max(maxLength, length);
            }

            return maxLength;
        }

        static int cIndex(int n) {
            return n + 1;
        }
        static int findIndex(int n, int numSize) {
            return n + numSize;
        }
    }

    static class Solution3 {
        // 使用HashMap
        static int  findMaxLength(int[] nums) {
            int maxLength = 0;
            //将找0和1的个数转变成计算-1和1和过程，因为-1+1==0，
            // 如果0和1的个数相等，这些数据的和必然为0，
            // 可以将和为0看作为0（-1）和1出现次数相等判断依据
            int sum01 = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0,-1);
            for (int i = 0; i < nums.length; i++) {
                //如果num[i] == 0转换成-1，否则为1
                sum01 += (nums[i] == 1) ? 1 : -1;
                //sum01 += (num[i] << 1) - 1;
                //如果map中存在这个和
                if(map.containsKey(sum01)) {
                    //找到对应的索引
                    int preIndex = map.get(sum01);
                    //比较已知的最大长度和新的最大长度
                    maxLength = Math.max(maxLength, i - preIndex);
                }else {
                    map.put(sum01, i);
                }
            }
           return maxLength;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,0,0,0,1,0,0,0,1,1,1,0,1,0};
        System.out.println("Solution1: " + Solution1.findMaxLength(nums));
        System.out.println("Solution2: " + Solution2.findMaxLength(nums));
        System.out.println("Solution3: " + Solution3.findMaxLength(nums));
    }
}
