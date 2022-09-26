package cn.offer;

/**
 * 题目：求旋转数组的最小数字
 * 把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转，输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：
 * {3，4，5，1，2} 为 {1，2，3，4，5}的一个旋转，该数组的最小值为1.
 * 提醒：
 * 给出的所有元素都大于0，若数组长度小于0，请返回-1。假设数组中不存在重复元素
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-26 22:46
 **/
public class Offer6 {

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        int[] arr2 = {2, 2, 2, 0, 1};
        int[] arr3 = {1, 1};
        System.out.println(Offer6.minInReversingList(arr1));
        System.out.println(Offer6.minInReversingList(arr2));
        System.out.println(Offer6.minInReversingList(arr3));
    }

    /**
     * 二分查找：时间复杂度O(log n)  空间复杂都：O(1)
     *
     * @param arr
     * @return
     */
    public static int minInReversingList(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return arr[left];
    }
}
