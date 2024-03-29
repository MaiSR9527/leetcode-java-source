package cn.offer;

/**
 * 题目：替换字符串中的空格
 * 题目描述 题目描述：将一个字符串中的空格替换成“%20”。例如：当字符串为 We Are
 * Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 * <p>
 * 思路：从后往前复制，数组长度会增加，或使用 StringBuilder、StringBuffer 类
 * 时间复杂度：O(n)，空间复杂度：O(n)
 * <p>
 * 地址：https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-10
 */
public class Offer5 {
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (String.valueOf(c).equals(" ")) {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
