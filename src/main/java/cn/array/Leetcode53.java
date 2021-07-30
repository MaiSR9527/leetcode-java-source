package cn.array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 难度：简单
 * 题目地址：https://leetcode-cn.com/problems/maximum-subarray/
 * 动态规划
 * https://mirrors.tuna.tsinghua.edu.cn/jenkins/updates/update-center.json
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:24
 */
public class Leetcode53 {
    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] a = {1, 4, 0, -2, 9, 10, -10};
        leetcode53.maxSubArray(a);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
