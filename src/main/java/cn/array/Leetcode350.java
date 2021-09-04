package cn.array;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 难度： 简单
 * 地址： https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:24
 */
public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        return new int[10];
    }
}
