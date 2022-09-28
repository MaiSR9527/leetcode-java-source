package cn.offer;

/**
 * 题目：青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-28 23:17
 **/
public class Offer10Frog {
    public int numWays(int n) {
        // b 是 n+1 时的 a。所以 n 是返回 a
        int a = 1, b = 1, f = 0;
        for (int i = 0; i < n; i++) {
            f = (a + b) % 1000000007;
            a = b;
            b = f;
        }
        return a;
    }
}
