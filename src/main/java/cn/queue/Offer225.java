package cn.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：用队列实现栈
 * 链接：https://leetcode.cn/problems/implement-stack-using-queues/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-18 22:22
 **/
public class Offer225 {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public Offer225() {
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        int ans = queue.poll();
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
        return ans;
    }

    public int top() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        int ans = queue.poll();
        Queue<Integer> tmp = queue;
        help.offer(ans);
        queue = help;
        help = tmp;
        return ans;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
