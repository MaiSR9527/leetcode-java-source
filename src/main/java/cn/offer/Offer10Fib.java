package cn.offer;

/**
 * 题目：斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1
 * <p>
 * 示例：
 * 输入：n = 2
 * 输出：1
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * 地址：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-28 23:16
 **/
public class Offer10Fib {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, f = 1;
        for (int i = 2; i < n; i++) {
            a = b;
            b = f;
            f = (a + b) % 1000000007;
        }
        return f;
    }
}
