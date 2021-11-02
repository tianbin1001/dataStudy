package com.gediao.leetcode;

public class leetCode79 {

    class Solution {


        /**
         * 单词搜索
         * 回溯法
         * check(i,j,k) 标识从 (i, j)出发，能否搜到单词 work[k...]
         * 条件：
         * 1、如果board[i][j] != s[k]  false
         * 2、如果当前已经访问字符串的末尾，且对应的字符串依然匹配，直接返回true
         * 3、否则，遍历当前位置所有相邻位置，继续进行判断
         *
         * 还需要一个 board 等大小的 visited数组，用于记录是否访问过某个元素
         */
        public boolean exist(char[][] board, String word) {
            int h = board.length;
            int w = board[0].length;
            boolean[][] visited = new boolean[h][w];
            //每个位置都遍历计算
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    boolean flag = check(board, visited, i, j, 0, word);
                    if(flag)
                        return true;
                }
            }
            return false;
        }



        /**
         * 回溯递归函数
         * @param board
         * @param visited
         * @param i
         * @param j
         * @param k
         * @param s
         * @return
         */
        public boolean check(char[][] board, boolean[][] visited, int i, int j, int k, String s) {

            //如果当前位置对不上，返回false
            if(board[i][j] != s.charAt(k))
                return false;
                //如果当前已经结束，说明能匹配上了，返回true
            else if(k == s.length() - 1)
                return true;

            visited[i][j] = true;
            int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            //开始遍历四个方向了
            for(int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                //越界判断
                if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    //没访问过，才能计算
                    if(!visited[newi][newj]) {
                        //计算
                        boolean flag = check(board, visited, newi, newj, k + 1, s);
                        //如果能匹配上就不用再整了
                        if(flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            //回溯
            visited[i][j] = false;
            return result;
        }

    }


}
