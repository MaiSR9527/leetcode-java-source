package cn.tree;

import cn.common.TreeNode;

/**
 * 校验二叉树是否是BST
 * 难度中等
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Leetcode98 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；
        // 否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}
