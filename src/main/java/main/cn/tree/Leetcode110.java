package cn.tree;

import cn.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 难度简单
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Leetcode110 {

    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right));
    }

    /**
     * 自顶向下，会有很多重复的遍历
     *
     * @param node
     * @return
     */
    public int height(TreeNode node) {
        return node == null ? 0 : Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return recursion(root) != -1;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = recursion(root.left);
        int rightHeight = recursion(root.right);
        if (leftHeight == -1) {
            return -1;
        }
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
