package cn.tree;

import common.TreeNode;

/**
 * 有序数组还原成二叉搜索树
 * 难度简单
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Leetcode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

}