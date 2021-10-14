package com.gediao.leetcode;

/**
 *
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class leetCode76 {


        public static  String minWindow(String s, String t) {

            int[] map = new int[128];
            //将t中每个字符的数量初始化，作为滑动窗口的条件
            for(char ch : t.toCharArray())
                map[ch]++;
            //字符串数量，也是滑动窗口是否全覆盖的条件
            int count = t.length();
            int left = 0;
            int right = 0;
            //覆盖的最小长度
            int windowLength = Integer.MAX_VALUE;
            //覆盖串的起始位置
            int strStart = 0;
            while(right < s.length()) {
                //如果右侧能覆盖中的字符，count就减一，虽然这个时候没更新  count，但是对应位置已经--了，也就是 right指针扫过的字符  都变成 - 的了
                if(map[s.charAt(right++)]-- > 0)
                    count--;
                //如果全覆盖
                while(count == 0) {
                    //记录更小的滑动窗口
                    if(right - left < windowLength) {
                        windowLength = right - left;
                        strStart = left;
                    }
                    //满足条件下 左侧的滑动窗口右移，左指着扫过的会把他扶正，只有 当前为0的元素，才是t中包含的字符
                    if(map[s.charAt(left++)]++ == 0)
                        count++;
                }
            }
            if(windowLength != Integer.MAX_VALUE)
                return s.substring(strStart,strStart + windowLength);
            return "";
        }


         public static void main(String args[]){

             String s = "ADOBECODEBANC", t = "ABC";
             minWindow(s,t);
         }




}
