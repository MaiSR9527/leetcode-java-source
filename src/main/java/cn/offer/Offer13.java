package cn.offer;

/**
 * 题目：剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 地址：https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-29 22:50
 **/
public class Offer13 {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long ret = 1;
        //线段被我们分成以3为大小的小线段个数
        int lineNums = n / 3;
        for (int i = 1; i < lineNums; i++) {
            //从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
            ret = 3 * ret % p;
        }
        if (b == 0) {
            //刚好被3整数的，要算上前一段
            return (int) (ret * 3 % p);
        }
        if (b == 1) {
            //被3整数余1的，要算上前一段
            return (int) (ret * 4 % p);
        }
        //被3整数余2的，要算上前一段
        return (int) (ret * 6 % p);
    }
}
