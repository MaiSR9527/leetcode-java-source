package cn.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 难度简单
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Leetcode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> result = new ArrayList<>();
//        recursion(root, result);
//        return result;
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 递归遍历
     *
     * @param root
     * @param list
     */
    public void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        recursion(root.left, list);
        recursion(root.right, list);
    }


}
