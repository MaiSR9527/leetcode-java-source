package cn.array;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 难度：中等
 * 地址：https://leetcode-cn.com/problems/next-permutation/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-09-04 14:57:26
 */
public class Leetcode31 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 7, 6, 2};
        Leetcode31 leetcode31 = new Leetcode31();
        leetcode31.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 从后往前找到升序子序列，然后确定调整后的子序列最高位，剩余部分升序排序
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 找到第一次下降的位置
        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            --k;
        }
        // K的位置就是要调整的最高位

        if (k == -1) {
            // 说明数组是降序排列，因此升序调整数组
            Arrays.sort(nums);
            return;
        }
        // 一般情况 k>=0
        int i = k + 2;
        while (i < n && nums[i] > nums[k]) {
            // k位置后面第一个比k位置小的数
            ++i;
        }
        // 替换
        int temp1 = nums[k];
        nums[k] = nums[i - 1];
        nums[i - 1] = temp1;

        // k之后的部分做升序
        int start = k + 1;
        int end = n - 1;
        while (start < end) {
            int temp2 = nums[end];
            nums[end] = nums[start];
            nums[start] = temp2;
            ++start;
            --end;
        }
    }

    public void nextPermutation2(int[] nums) {
        int n = nums.length;
        // 找到第一次下降的位置
        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            --k;
        }
        // K的位置就是要调整的最高位

        if (k == -1) {
            // 说明数组是降序排列，因此升序调整数组
            Arrays.sort(nums);
            return;
        }
        // 一般情况 k>=0
        int i = k + 2;
        while (i < n && nums[i] > nums[k]) {
            // k位置后面第一个比k位置小的数
            ++i;
        }
        // 替换
        swap(nums, k, i - 1);

        // k之后的部分做升序
        int start = k + 1;
        int end = n - 1;
        while (start < end) {
            swap(nums, start, end);
            ++start;
            --end;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
