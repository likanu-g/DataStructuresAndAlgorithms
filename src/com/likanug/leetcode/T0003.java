package com.likanug.leetcode;

public class T0003 {
    /*
     输入：[7,1,5,3,6,4]
     输出：7
     解释：股票买卖问题，给出最大利润的数字
    */
    static class Solution1 {

        int maxProfit(int[] prices, int pricesSize) {
            if(pricesSize <= 1) {
                return 0;
            }
            int profit;
            int max = 0;
            //1、假设最后一天不卖
            profit = maxProfit(prices, pricesSize-1);
            if(profit > max) {
                max = profit;
            }
            //2、假设最后一天要卖出
            for(int i = 1; i <= pricesSize - 1; i ++) {
                profit = maxProfit(prices, i) + prices[pricesSize - 1] - prices[i - 1];
                if(profit > max) {
                    max = profit;
                }
            }
            return max;
        }

        public static void main(String[] args) {
            Solution1 solution1 = new Solution1();
            int maxProfit = solution1.maxProfit(new int[]{7, 1, 5, 3, 6, 4},6);
            System.out.println("maxProfit = " + maxProfit);

        }
    }

    static class Solution2 {

        int maxProfit(int[] prices, int pricesSize) {
            if(pricesSize <= 1) {
                return 0;
            }
            int[] profits = new int[pricesSize + 1];
            profits[1] = 0;
            for (int k = 2; k <= pricesSize; k++) {
                //1、假设最后一天不卖
                int profit;
                int max = 0;
                profit = profits[k - 1];

                if(profit > max) {
                    max = profit;
                }
                //2、假设最后一天要卖出
                for(int i = 1; i <= k - 1; i ++) {
                    profit = profits[i] + prices[k - 1] - prices[i - 1];
                    if(profit > max) {
                        max = profit;
                    }
                }
                profits[k] = max;
            }

            return profits[pricesSize];
        }

        public static void main(String[] args) {

            Solution2 solution2 = new Solution2();
            int maxProfit2 = solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4},6);
            System.out.println("maxProfit2 = " + maxProfit2);

        }
    }

    static class Solution3 {

        int maxProfit(int[] prices, int pricesSize) {
            int total = 0;
            //注意这里的数组边界
            for (int i = 0; i + 1 < pricesSize; i++) {
                //比较相邻两天的差价
                if(prices[i] < prices[i + 1]) {
                    total += prices[i + 1] - prices[i];
                }
            }
            return total;
        }

        public static void main(String[] args) {

            Solution3 solution3 = new Solution3();
            int maxProfit3 = solution3.maxProfit(new int[]{7, 1, 5, 3, 6, 4},6);
            System.out.println("maxProfit3 = " + maxProfit3);

        }
    }
}
