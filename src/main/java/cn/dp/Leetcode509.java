package cn.dp;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * 难度：简单
 * <p>
 * 地址：https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:24
 */
public class Leetcode509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 1, sum;
        for (int i = 3; i <= n; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
