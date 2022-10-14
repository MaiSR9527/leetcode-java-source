package cn.offer;

/**
 * 题目：把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * <p>
 * 链接：https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-14 23:32
 **/
public class Offer45 {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        //解决大数问题，将数字转换为字符串
        for (int i = 0 ; i < nums.length; ++i) {
            arr[i] = String.valueOf(nums[i]);
        }

        quickSort(arr,0,arr.length-1);
        StringBuffer str = new StringBuffer();

        for (String x : arr) {
            str.append(x);
        }
        return str.toString();
    }
    public void quickSort(String[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left;
        int hight = right;
        int i = low+1;
        String pivot = arr[low];

        while (i <= hight) {
            //比较大小
            if ((pivot+arr[i]).compareTo(arr[i]+pivot) > 0 ) {
                swap(arr,i++,low++);
            } else if ((pivot+arr[i]).compareTo(arr[i]+pivot) < 0) {
                swap(arr,i,hight--);
            } else {
                i++;
            }
        }

        quickSort(arr,left,low-1);
        quickSort(arr,hight+1,right);

    }
    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
