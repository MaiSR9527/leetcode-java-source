package cn.tree;

import cn.common.TreeNode;

/**
 * 判断两个二叉树是否相同
 * 难度简单
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Leetcode100 {
    /**
     * 深度优先搜索：递归遍历两个二叉树、先比较两个二叉树的两个二叉树的根节点的值
     * 再比较左子树，然后右子树上的值
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
