package cn.algorithm;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-09-16 21:44:17
 */
public class BubbleSort {

    public int[] sort(int[] arr) {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) { // 每次需要排序的长度
            for (int j = 0; j < i; j++) { // 从第一个元素到第i个元素
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }//loop j
        }//loop i
        return arr;
    }
}
