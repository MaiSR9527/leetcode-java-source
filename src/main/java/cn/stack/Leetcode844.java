package cn.stack;

import java.util.Stack;

/**
 * 题目：比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * 链接：https://leetcode.cn/problems/backspace-string-compare
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-29 10:59:40
 */
public class Leetcode844 {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        boolean b = new Leetcode844().backspaceCompare(s, t);
        System.out.println(b);
    }

    public boolean backspaceCompare(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c1 : s.toCharArray()) {
            if (c1 == '#' && stack1.isEmpty()){
                continue;
            }
            if (c1 == '#') {
                stack1.pop();
            } else {
                stack1.push(c1);
            }
        }
        for (char c2 : t.toCharArray()) {
            if (c2 == '#' && stack2.isEmpty()){
                continue;
            }
            if (c2 == '#') {
                stack2.pop();
            } else {
                stack2.push(c2);
            }

        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (stack1.size() != 0) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return stack2.isEmpty();
    }
}
