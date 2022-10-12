package cn.offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目：数据流中的中位数
 * <p>
 * 链接：https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-12 22:42
 **/
public class Offer41 {

    Queue<Integer> A, B;

    public Offer41() {
        // 小顶堆，保存较大的一半
        A = new PriorityQueue<>();
        // 大顶堆，保存较小的一半
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}
