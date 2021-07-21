package cn.tree;

import cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 难度简单
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        // 广度优先：迭代
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;

    }

    /**
     * 深度优先：递归
     *
     * @param root
     * @return
     */
    public int recursion(TreeNode root) {

        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
