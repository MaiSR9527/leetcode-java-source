package cn.offer;

import java.util.Arrays;

/**
 * 题目：最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-12 22:43
 **/
public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            return quickSort(arr, k, l, i - 1);
        }
        if (i < k) {
            return quickSort(arr, k, i + 1, r);
        }
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }


}
