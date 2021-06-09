package cn.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * title:不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 难度中等
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-06-08 23:38:30
 */
public class Leetcode95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    /**
     * 递归，回溯
     *
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    result.add(currTree);
                }
            }

        }
        return result;

    }
}
