package cn.tree;

/**
 * title:不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * eg:
 * 输入：n = 3
 * 输出：5
 * <p>
 * 难度中等
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-06-08 23:38:30
 */
public class Leetcode96 {

    public int numTrees(int n) {
        return dp(n);
    }

    public int dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int mathWay(int n) {
        long sum = 1;
        for (int i = 0; i < n; i++) {
            sum = sum * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) sum;
    }
}
