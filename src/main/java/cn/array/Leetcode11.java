package cn.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 地址：https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author MaiShuRen
 * @version v1.0
 * @since 2020/12/23 23:54
 */
public class Leetcode11 {
    public int maxArea(int[] height) {
        // 双指针
        int front = 0, end = height.length - 1, result = 0;
        while (front < end) {
            int minHeight = height[front] < height[end] ? height[front++] : height[end--];
            int area = (end - front + 1) * minHeight;
            result = Math.max(area, result);
        }
        return result;
    }
}
