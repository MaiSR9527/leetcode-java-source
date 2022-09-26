package cn.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型
 * 思路：
 * 一个栈压入元素，而另一个栈作为缓冲，将栈 1 的元素出栈后压入栈 2中。也可以将栈 1 中的最后一个元素直接出栈，而不用压入栈 2 中再出栈。
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-26 22:40
 **/
public class Offer5 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int num) {
        stack1.push(num);
    }

    public int pop() {
        if (stack1.empty() && stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack1.empty() && stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

}
