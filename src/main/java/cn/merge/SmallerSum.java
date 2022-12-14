package cn.merge;

import java.util.Arrays;

/**
 * 一个数组，数组中的每一个元素，左边比它小的数都累加起来
 * <p>
 * eg：[6,3,5,1,3,8,9]  => [0,0,3,0,1,18,26] => 48
 *
 * @author MaiShuRen
 * @site <a href="https://www.maishuren.top">我的博客</a>
 * @since 2022-10-29 16:13
 **/
public class SmallerSum {

    public static int smallerSum(int[] arr) {
        System.out.println(Arrays.toString(arr));
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int pL = left;
        int pR = mid + 1;
        int res = 0;
        while (pL <= mid && pR <= right) {
            res += arr[pL] < arr[pR] ? (right - pR + 1) * arr[pL] : 0;
            help[i++] = arr[pL] < arr[pR] ? arr[pL++] : arr[pR++];
        }
        while (pL <= mid) {
            help[i++] = arr[pL++];
        }
        while (pR <= right) {
            help[i++] = arr[pR++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 测试：拷贝数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 测试：对比结果
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        // boolean succeed = true;
        // for (int i = 0; i < 1; i++) {
        //     int[] arr1 = generateRandomArray(maxSize, maxValue);
        //     int[] arr2 = copyArray(arr1);
        //     if (smallerSum(arr1) != comparator(arr2)) {
        //         succeed = false;
        //         System.out.println(Arrays.toString(arr1));
        //         System.out.println(Arrays.toString(arr2));
        //         break;
        //     }
        // }
        // System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        // int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arr = {6, 3, 5, 1, 3, 8, 9};
        System.out.println(smallerSum(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

}
