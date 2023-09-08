package com.question.algorithm.easy;

/**
 * @author liushaogeng
 * @date 2022/10/7 14:30
 * @description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class ClimbStairs {
    public int solution(int n){
        int p = 0, q = 0, r = 1;
        for(int i=1;i<=n;i++){
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.solution(7);
    }
}
