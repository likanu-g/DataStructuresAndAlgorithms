package com.likanug.leetcode;

import java.util.LinkedHashSet;

public class T0006 {
    /*
     输入：S:"ab##cc" 和 T:"##a#cc"
     输出：true
     解释：#为backspace删除键，判断S、T两个字符串是否相同
         1 <= S.length <= 200;
         1 <= T.length <= 200;
    */

    static class Solution1 {

        String process(String s) {
            int j = 0;
            char[] schar = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if(schar[i] != '#') {
                    schar[j] = schar[i]; //j <= i,所以 schar[i] 不会覆盖schar[j]的值
                    j ++;
                }else {
                    if(j > 0) {
                        j --;
                    }
                }
            }
            return new String(schar).substring(0,j);
        }

        boolean backspaceCompare(String s, String t) {
            return process(s).equals(process(t));
        }
    }

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.backspaceCompare("aa#bcc#d", "###abcd"));
    }
}
