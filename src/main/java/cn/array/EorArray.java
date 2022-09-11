package cn.array;

/**
 * 一个数组内只有一个数会出现奇数次，其他的数会出现偶数次。
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-11
 */
public class EorArray {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 5, 2, 6, 4, 2, 6, 7, 7, 4, 2, 9, 9,};
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println(eor);
    }
}
