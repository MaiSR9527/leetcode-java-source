package cn.dp;

/**
 * 第n个斐波那契数
 * 斐波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T0=0
 * T1=1
 * T2=1
 * T_3 = T0 + T1 + T2 = 2
 * T_4 = T1 + T2 + T3 = 4
 * T_5 = T2 + T3 + T4 = 7
 * <p>
 * 难度：简单
 * 地址：https://leetcode-cn.com/problems/n-th-tribonacci-number/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:24
 */
public class Leetcode1137 {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int p1 = 1, p2 = 1, p3 = 0, res = 0;
        for (int i = 3; i <= n; i++) {
            res = p1 + p2 + p3;
            p3 = p2;
            p2 = p1;
            p1 = res;
        }
        return res;
    }
}
