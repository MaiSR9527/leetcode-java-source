package cn.linklist;

import cn.common.ListNode;

/**
 * 题目：移除链表元素
 * 例子：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 链接：https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-16 19:35
 **/
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
