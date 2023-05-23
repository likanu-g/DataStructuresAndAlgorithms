package com.likanug.leetcode;

public class T0011 {
    /*
     输入: 二维数组 nums [[1,2,5]
                        [4,5,6]
                        [7,8,9]]
     输出：数组左上到右下的最小路径和例如1->2->5->6->9的路径和最小

    */

    static class Solution1 {
        static int  minPathSum(int[][] grid) {
            int m = grid.length - 1;
            int n = grid[0].length - 1;
            //从最小值处反向查找
            return minPartialPathSum(grid, m, n);
         }

        /**
         * 从数组右下角反向查找
         * @param grid 数组
         * @param row 行
         * @param col 列
         * @return 最小值
         */
        static  int minPartialPathSum(int[][] grid, int row, int col) {
            if(row == 0 && col == 0) {
                return grid[0][0];
            }
            int min = Integer.MAX_VALUE;
            if(row - 1 >= 0)  {
                int upMin = minPartialPathSum(grid, row - 1, col) + grid[row][col];
                min = Math.min(min, upMin);
                System.out.printf("row: %d , col: %d , upMin:  %d \n", row, col, upMin);
            }
            if(col - 1 >= 0) {
                int leftMin = minPartialPathSum(grid, row, col - 1) + grid[row][col];
                min = Math.min(min, leftMin);
                System.out.printf("row: %d , col: %d , leftMin:%d \n", row, col, leftMin);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        System.out.println(Solution1.minPathSum(grid));
    }
}
