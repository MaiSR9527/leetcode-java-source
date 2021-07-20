package cn.tree;

import cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树是否对称
 * 难度简单
 * https://leetcode-cn.com/problems/symmetric-tree/
 * ps: 递归和迭代两种方法，递归最慢。
 */
public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
//        return solutionRecursion(root, root);
        return solutionIteration(root, root);
    }

    /**
     * 递归，维护一个队列
     * 一颗对称的二叉树：
     * 左边树的左子树等于右边树的右子树
     * 左边树的右子树等于右边树的左子树
     *
     * @param leftTree
     * @param rightTree
     * @return
     */
    private boolean solutionIteration(TreeNode leftTree, TreeNode rightTree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(leftTree);
        queue.offer(rightTree);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);

        }

        return true;
    }

    /**
     * 递归
     * 一颗对称的二叉树：
     * 左边树的左子树等于右边树的右子树
     * 左边树的右子树等于右边树的左子树
     *
     * @param leftTree
     * @param rightTree
     * @return
     */
    public boolean solutionRecursion(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        return leftTree.val == rightTree.val
                && solutionRecursion(leftTree.left, rightTree.right)
                && solutionRecursion(leftTree.right, rightTree.left);
    }


}
