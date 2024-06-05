package com.accumulation.answer;

// 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//        示例 1：

//        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//        输出：7
//        解释：因为路径 1→3→1→1→1 的总和最小。
//        示例 2：
//        输入：grid = [[1,2,3],[4,5,6]]
//        输出：12

public class MinumPath {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int [][]paths = new int [grid.length][grid[0].length];
        // 1、init paths
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++){
                paths[i][j] = grid[i][j];
            }
        }

        // 2、动态规划方式，计算最小路径
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++){
                // 取最小值
                if (i == 0 && j == 0) {
                    paths[i][j] = paths[i][j];
                } else if (i == 0) {
                    paths[i][j] = paths[i][j] + paths[i][j-1];
                } else if ( j == 0) {
                    paths[i][j] = paths[i][j] + paths[i-1][j];
                } else {
                    paths[i][j] = paths[i][j] + (paths[i-1][j] > paths[i][j-1] ? paths[i][j-1] : paths[i-1][j]);
                }
            }
        }
        return paths[grid.length-1][grid[0].length-1];
    }
}