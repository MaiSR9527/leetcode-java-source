package cn.stack;

import java.util.Stack;

/**
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * 难度：难
 * 地址：https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-01-09 23:46
 **/
public class Leetcode32 {

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    continue;
                }
                if (c == stack.peek()) {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
