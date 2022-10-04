package cn.offer;

import cn.common.TreeNode;

/**
 * 题目：对称的二叉树
 * 输入一个二叉树，判断该二叉树书否是对称
 * <p>
 * 链接：https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-04 15:34:46
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }
}
