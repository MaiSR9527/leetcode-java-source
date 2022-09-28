package cn.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 地址：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-28 22:46
 **/
public class Offer3 {

    public static void main(String[] args) {

    }

    /**
     * 使用hash set
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        int temp;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
