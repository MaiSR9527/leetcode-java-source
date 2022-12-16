package cn.array;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/find-the-duplicate-number">287.寻找重复数</a>
 *
 * @author MaiShuRen
 * @site <a href="https://www.maishuren.top">我的博客</a>
 * @since 2022-12-16 18:34
 **/
public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        int pointer1 = 0;
        int pointer2 = slow;
        while (pointer1 != pointer2) {
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }

        return pointer1;
    }
}
