package cn.array;

/**
 * 题目：寻找数组的中心下标
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 * 难度：简单
 * 地址：https://leetcode-cn.com/problems/find-pivot-index/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-09-02 22:49:01
 */
public class Leetcode724 {

    public int pivotIndex(int[] nums) {
        // pre = preSum - cur 时，返回 cur 位置索引
        int cur = 0, pre = 0, preSum = 0, len = nums.length;
        // 数组的和
        for (int num : nums) {
            preSum += num;
        }

        for (int i = 0; i < len; i++) {
            // 到当前索引为止的前缀和 cur
            cur = pre + nums[i];
            // pre = preSum - cur 时，意味着前后之和相等
            if (pre == preSum - cur) {
                return i;
            }
            pre = cur;
        }
        return -1;
    }
}
