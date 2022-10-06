package cn.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二维数组中的查找
 *
 * 在一个二维数组中，每一行都按照从左到右递增排序。每一列都按照从上到下递增排序
 * 输入这个数组和一个目标数，判断数组中是否存在这个数
 *
 * 地址：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-10
 */
public class Offer4 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5, 7, 8, 10},
                {2, 6, 9, 11, 14},
                {5, 7, 15, 16, 19},
                {8, 17, 25, 26, 29},
                {10, 27, 35, 36, 39},
        };
        System.out.println("========双指针解法 时间复杂度O(mn) 空间复杂度O(1)=======");
        System.out.println(Offer4.towPointer(arr, 6));
        System.out.println(Offer4.towPointerReturnIndex(arr, 6));
        // 有序 二分查找
        System.out.println("===========二分查找 时间复杂度O(log mn) 空间复杂度O(1)=========");
        System.out.println(binarySearch(arr, 9));

    }

    public static boolean towPointer(int[][] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int row = 0;
        int col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return true;
            }
            if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static List<Integer> towPointerReturnIndex(int[][] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        int row = 0;
        int column = arr[0].length - 1;

        while (row < arr.length && column >= 0) {
            if (arr[row][column] == target) {
                result.add(row);
                result.add(column);
                return result;
            }
            if (arr[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return result;
    }

    public static boolean binarySearch(int[][] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length * arr[0].length - 1;
        int col = arr[0].length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = arr[mid / col][mid % col];
            if (value == target) {
                System.out.println(mid / col + "," + mid % col);
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
