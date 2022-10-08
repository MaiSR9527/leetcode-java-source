package cn.offer;

import java.util.Stack;

/**
 * 题目：二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * <p>
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 提示：
 * 数组长度 <= 1000
 * <p>
 * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-08 12:15
 **/
public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
