package cn.offer;

/**
 * 题目：数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * <p>
 * 限制：
 * <p>
 * 0 <= n < 2^31
 * <p>
 * 链接：https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-14 23:30
 **/
public class Offer44 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1.
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2.
        long num = start + (n - 1) / digit;
        // 3.
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

}
