package cn.dp;

import java.util.Arrays;

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
 * @site <a href="https://www.maishuren.top">我的博客</a>
 * @date 2020/12/23 23:24
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int coin : coins) {
                // 子问题无解
                if (i - coin < 0) {
                    continue;
                }
                arr[i] = Math.min(arr[i], 1 + arr[i - coin]);
            }
        }
        return arr[amount] == amount + 1 ? -1 : arr[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        Leetcode322 leetcode322 = new Leetcode322();
        System.out.println(leetcode322.coinChange(coins, 11));
    }
}
