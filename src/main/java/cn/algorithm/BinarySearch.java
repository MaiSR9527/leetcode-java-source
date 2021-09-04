package cn.algorithm;

/**
 * 有序数组二分查找
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-09-04 13:34:39
 */
public class BinarySearch {

    public int searchRecursion(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return searchRecursion(nums, target, 0, nums.length);
    }

    /**
     * 递归实现二分查找
     *
     * @param nums   目标数组
     * @param target 查找的书
     * @param start  开始索引
     * @param end    结束索引
     * @return 结果
     */
    private int searchRecursion(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return searchRecursion(nums, target, start, mid - 1);
        } else {
            return searchRecursion(nums, target, mid + 1, end);
        }
    }

    /**
     * 遍历实现二分查找
     *
     * @param nums   目标数组
     * @param target 查找的数
     * @return 索引
     */
    public int search(int[] nums, int target) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        if (target < nums[start] || target > nums[end]) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (start - end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = end + 1;
            }
        }
        return -1;
    }
}
