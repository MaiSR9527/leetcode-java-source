package cn.offer;

/**
 * 题目：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 限制：
 * 1 <= 数组长度 <= 50000
 * <p>
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-11 23:06
 **/
public class Offer39 {

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }
        // 当无众数时返回 0
        return count > nums.length / 2 ? x : 0;
    }

}
