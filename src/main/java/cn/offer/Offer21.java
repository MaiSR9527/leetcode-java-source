package cn.offer;

/**
 * 题目：调整数组顺序使奇数位于偶数位前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-03 17:15
 */
public class Offer21 {
    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 判断前面的是不是奇数，奇数不用动
            if ((nums[left] & 1) != 0) {
                left++;
                continue;
            }
            // 判断后面的是不是偶数，偶数不用动
            if ((nums[right] & 1) != 1) {
                right--;
                continue;
            }
            // 交换
            nums[left] = nums[right] ^ nums[left];
            nums[right] = nums[right] ^ nums[left];
            nums[left] = nums[right] ^ nums[left];
        }
        return nums;
    }

}
