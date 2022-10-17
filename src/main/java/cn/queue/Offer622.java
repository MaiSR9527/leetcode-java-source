package cn.queue;

/**
 * 题目：设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，
 * 即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * 链接：https://leetcode.cn/problems/design-circular-queue
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-17 23:27
 **/
public class Offer622 {
    private int[] arr;
    private int pushIndex;
    private int pollIndex;
    private int size;
    private final int limit;

    public Offer622(int limit) {
        arr = new int[limit];
        this.pushIndex = 0;
        this.pollIndex = 0;
        this.size = 0;
        this.limit = limit;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        this.arr[pushIndex] = value;
        pushIndex = nextIndex(pushIndex);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        size--;
        pollIndex = nextIndex(pollIndex);
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.arr[pollIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int i = pushIndex == 0 ? limit - 1 : pushIndex -1;
        return this.arr[i];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }
}
