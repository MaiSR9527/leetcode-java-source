package cn.linklist;

import cn.common.ListNode;

/**
 * 题目：反转单链表
 * 例子：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 链接：https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-16 18:47
 **/
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
