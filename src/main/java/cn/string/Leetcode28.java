package cn.string;

/**
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:55
 */
public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needLen = needle.length();
        if (hayLen < needLen) {
            return -1;
        }
        if (needLen == 0) {
            return 0;
        }
        for (int i = 0; i < hayLen - needLen + 1; ++i) {
            int j;
            for (j = 0; j < needLen; j++) {
                // 不符合，直接跳出，主串指针直接后移一位
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needLen) {
                return i;
            }
        }
        return -1;
    }
}
