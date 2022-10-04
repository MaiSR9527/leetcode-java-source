package cn.offer;

import cn.common.TreeNode;

/**
 * 题目：树的子结构
 * 输入两个二叉树，判断b是不是a的子结构。约定空树不是任意一个字数的子结构
 * <p>
 * 链接：https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-04 14:38:19
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recursion(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recursion(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recursion(A.left, B.left) && recursion(A.right, B.right);
    }
}
