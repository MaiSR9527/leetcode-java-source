package cn.offer;

import java.util.Stack;

/**
 * 题目：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 链接：https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-06 21:31
 **/
public class Offer26 {

    Stack<Integer> xStack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public Offer26() {
        xStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        xStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (xStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
