package cn.tree;

import cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * 难度简单
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 先计算左子树的最小深度
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        // 计算出左子树的最小深度
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /**
     * 深度优先：优化
     *
     * @param root
     * @return
     */
    public int recursion(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        // 先计算左子树的最小深度
//        int minDepth = Integer.MAX_VALUE;
//        if (root.left != null) {
//            minDepth = Math.min(minDepth(root.left), minDepth);
//        }
//        // 计算出左子树的最小深度
//        if (root.right != null) {
//            minDepth = Math.min(minDepth(root.right), minDepth);
//        }
//        return minDepth + 1;
        if (root == null) {
            return 0;
        }
        int leftHeight = recursion(root.left);
        int rightHeight = recursion(root.right);
        return (root.left == null || root.right == null) ? leftHeight + rightHeight + 1 :
                Math.min(leftHeight, rightHeight) + 1;
    }

    /**
     * 广度优先,迭代
     * @param root
     * @return
     */
    public int iterate(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }


    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }


}
