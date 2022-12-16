package cn.array;

/**
 * 编写一个高效的算法来判断m * n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 难度：中等
 * 地址：https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-09-04 14:16:29
 */
public class Leetcode74 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        // 二分查找
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int minEle = matrix[mid / n][mid % n];
            if (minEle < target) {
                left = mid + 1;
            } else if (minEle > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
