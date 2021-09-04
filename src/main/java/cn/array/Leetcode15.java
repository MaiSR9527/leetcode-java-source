package cn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 难度：中等
 * 地址：https://leetcode-cn.com/problems/3sum/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-08-22 17:35:25
 */
public class Leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        return twoPointers(nums);
    }

    public List<List<Integer>> twoPointers(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;

        // 遍历元素
        for (int i = 0; i < len; i++) {
            // 如果当前元素已经大于零，直接结束循环
            if (nums[i] > 0) {
                break;
            }
            // 如果当前数据已经出现过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                    while (left < right && nums[left] == nums[left - 1]) {
                        ++left;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        --right;
                    }
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return result;
    }

}
