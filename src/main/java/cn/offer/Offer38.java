package cn.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 * 1 <= s 的长度 <= 8
 * <p>
 * 链接：https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-11 23:05
 **/
public class Offer38 {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    void dfs(int x) {
        // 添加排列方案
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
