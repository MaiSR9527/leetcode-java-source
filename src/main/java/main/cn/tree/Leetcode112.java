package cn.tree;

import cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum
 * 判断该树中是否存在 根节点到叶子节点 的路径
 * 这条路径上所有节点值相加等于目标和targetSum
 * <p>
 * 难度简单
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Leetcode112 {

    /**
     * 广度优先
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    /**
     * 深度优先
     *
     * @param root
     * @param targetNum
     * @return
     */
    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null || root.right == null) {
            return targetSum == root.val;
        }

        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }




}
