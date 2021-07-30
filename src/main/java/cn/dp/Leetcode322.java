package cn.dp;

/**
 * 零钱兑换:
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 难度：中等
 * 地址：https://leetcode-cn.com/problems/coin-change/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:24
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return -1;
        }
        int res = 0;
        for (int coin : coins) {

        }
        return 0;
    }
}
