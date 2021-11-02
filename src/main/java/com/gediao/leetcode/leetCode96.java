package com.gediao.leetcode;

public class leetCode96 {



    class Solution {
        /**
         * 不同的二叉搜索树
         * 动态规划
         * 假设dp[i] 的含义是 当节点数为 i 的 时候的  二叉搜索树的种类
         * 最终解 ： dp[n]
         * 初始条件 : dp[0] = 1 , dp[1] = 1 , dp[2] = 2
         * 状态转移方程：
         *        i=1
         * G(j)=  ∑G(i−1)⋅G(j−i)
         *        j
         * 状态转移方程解释：当j为树的 根 的时候，所有二叉搜索树的个数可以划分为两个子问题
         * 左子树的 个数 * 右子树的 个数
         *  左子树有1个数字 * 右子树有 j - 1 个数字
         * +左子树有2个数字 * 右子树有 j - 2 个数字
         * ...
         * +左子树有j-1个数字 * 右子树有 1 个数字
         *
         * 每个左右子树的小问题  都需要 递归调用 G 的函数
         */
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            //初始条件
            G[0] = 1;
            G[1] = 1;

            /**
             * 状态转换方程
             */
            for(int i = 2; i <= n; i++) {
                for(int j = 1; j <= i; j++) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }


}
