package com.likanug.leetcode;

import java.util.Arrays;

public class T0013 {
    /*
     凑零钱问题，现有 1,2,5三种面值的硬币，每种硬币的数量无限，再给出一个总金额amount，问最少需要几枚硬币可以凑出这个金额，如果无法凑出返回-1
    */

    static class Solution1 {

        /**
         * 递归解决，时间复杂度为O(n^k),指数级别
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            int rest = Integer.MAX_VALUE;
            if (amount < 0) {
                return -1;
            } else if (amount == 0) {
                return 0;
            } else {
                for (int coin : coins) {
                    int subProblem = dp(coins, amount - coin);
                    // 如果问题无解，直接退出，继续下一个
                    if (subProblem == -1) {
                        continue;
                    }
                    //此处的 1 应该理解为解决问题的步骤个数，并不是硬币的面值
                    //1 + subProblem 的意思就是在当前硬币的基础上，再加上解决子问题所需的最小硬币数量(而不是硬币的面值1)
                    //例如 ，总金额为12，最少硬币数量为3：应该是（5,5,2），不需要使用1面值的硬币，此处并不是某些地方解释的，先
                    rest = Math.min(rest, 1 + subProblem);
                }
            }
            return rest;
        }
    }


    static class Solution2 {

        /**
         * 循环解决，时间复杂度为O(n^k),指数级别
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            //初始化填充数组的所有元素都为amount+1
            //初始化为amount + 1 的原因是，如果初始化为amount可能存在硬币面值都为1的可能，
            // 此时amount + 1即为无穷大，当然也可以初始化为Integer.MAX_VALUE，amount + 1只是最小的无穷值
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] coins = {1, 2, 5};
        System.out.println("solution1 = " + solution1.coinChange(coins, 13));
        Solution2 solution2 = new Solution2();
        System.out.println("solution2 = " + solution2.coinChange(coins, 13));
        System.out.println(solution1.coinChange(coins, 13) == solution2.coinChange(coins, 13));
    }
}
