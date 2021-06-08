package tree;

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

    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; i++) {

        }

    }
}
