package cn.offer;

import cn.common.ListNode;

/**
 * 题目：合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 1000
 * <p>
 * 地址：https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-03 19:42
 */
public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode cur = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return listNode.next;
    }
}
