package cn.algorithm;

import java.util.Arrays;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-28 21:33
 **/
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int pL = left;
        int pR = mid + 1;
        // min case: tow element,left === mid, mid + 1 === right
        // merge：left < mid && mid + 1 < right ===> 左右区间合并
        while (pL <= mid && pR <= right) {
            help[i++] = arr[pL] <= arr[pR] ? arr[pL++] : arr[pR++];
        }
        // mini case:
        // left 位置上的是比right位置上大的话，pR++。
        // 说明先进入help的是right上的数，此时需要把left上放进help，并且此时是pL===mid && mid
        // 否则 pR === right

        // merge:
        // 左右区间，总会有一个区间会被排序完，放进help。
        // 如果左区间被合并完，那么执行左区间的指针就会溢出，左区间的元素全都已经被放进了help。那把右区间的所有元素放进help，同时移动指向右区间的指针直至溢出。
        // 如果是右区间被合并完，同理
        while (pL <= mid) {
            help[i++] = arr[pL++];
        }
        while (pR <= right) {
            help[i++] = arr[pR++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(5, 100);
        System.out.println(Arrays.toString(arr));
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

}
