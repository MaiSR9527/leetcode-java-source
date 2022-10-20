package cn.array;

/**
 * 递归求最大值
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-20 22:16
 **/
public class GetArrayMax {

    public int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
