package cn.offer;

import cn.common.TreeNode;

/**
 * 题目：二叉树的镜像
 * 输入一个二叉树，输入与之对称的二叉树
 * <p>
 * 链接：https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/solution/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-04 15:23:32
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
