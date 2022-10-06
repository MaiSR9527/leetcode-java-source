package cn.offer;

/**
 * 题目：数值的整次数方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * <p>
 * 链接：https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-02 16:48
 */
public class Offer16 {

    public static void main(String[] args) {
        System.out.println(Offer16.myPow(2.0, 10));
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;

    }

    public static double myPow2(double x, int n) {
        return 0.0;
    }
}
