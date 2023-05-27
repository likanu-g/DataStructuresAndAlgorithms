package com.likanug.leetcode;

public class T0012 {
    /*
     优化求斐波那契数的算法时间复杂度

    */

    static class Solution1 {
        /**
         * 时间复杂度为O(2^n)
         *
         * @param n
         * @return
         */
        Long fib(int n) {
            if (n == 0) {
                return 0L;
            } else if (n == 1 || n == 2) {
                return 1L;
            } else {
                return fib(n - 1) + fib(n - 2);
            }
        }

    }

    static class Solution2 {
        /**
         * 时间复杂度度为O(n),空间复杂度为O(n)
         *
         * @param n
         * @return
         */
        long fib(int n) {
            long[] memo = new long[n + 1];
            if (n > 0) {
                return help(n, memo);
            } else {
                return 0;
            }
        }

        long help(int n, long[] memo) {
            if (n == 1 || n == 2) {
                return 1;
            } else if (memo[n] != 0) {
                return memo[n];
            } else {
                memo[n] = help(n - 1, memo) + help(n - 2, memo);
            }
            return memo[n];
        }

    }

    static class Solution3 {
        /**
         * 使用循环代替递归，时间复杂度度为O(n),空间复杂度为O(n)
         *
         * @param n
         * @return
         */
        long fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1 || n == 2) {
                return 1;
            } else {
                long[] dp = new long[n + 1];
                dp[1] = 1;
                dp[2] = 1;
                for (int i = 3; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
                return dp[n];
            }
        }
    }

    static class Solution4 {
        /**
         * 使用循环代替递归，时间复杂度度为O(n),空间复杂度为O(1)
         *
         * @param n
         * @return
         */
        long fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1 || n == 2) {
                return 1;
            } else {
                long prev = 1;
                long curr = 1;
                for (int i = 3; i <= n; i++) {
                    long sum = prev + curr;
                    prev = curr;
                    curr = sum;
                }
                return curr;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        long time1 = System.currentTimeMillis();
        long fib1 = solution1.fib(50);
        long time2 = System.currentTimeMillis();
        System.out.printf("fib1  = %d, time = %d\n", fib1, (time2 - time1) / 1000); //43s
        Solution2 solution2 = new Solution2();
        long time3 = System.currentTimeMillis();
        long fib_7 = solution2.fib(50);
        long time4 = System.currentTimeMillis();
        System.out.printf("fib_7 = %d, time = %d\n", fib_7, (time4 - time3) / 1000); //0s
        System.out.println(fib1 == fib_7);
        Solution3 solution3 = new Solution3();
        long time5 = System.currentTimeMillis();
        long fib_50 = solution3.fib(50);
        long time6 = System.currentTimeMillis();
        System.out.printf("fib_50 = %d, time = %d\n", fib_50, (time6 - time5) / 1000); //0s
        System.out.println(fib1 == fib_7 && fib_50 == fib1);

        Solution4 solution4 = new Solution4();
        long time7 = System.currentTimeMillis();
        long fib_5_0 = solution4.fib(50);
        long time8 = System.currentTimeMillis();
        System.out.printf("fib_5_0 = %d, time = %d\n", fib_5_0, (time8 - time7) / 1000); //0s
        System.out.println(fib1 == fib_7 && fib_50 == fib1 && fib_5_0 == fib_7);
    }
}
