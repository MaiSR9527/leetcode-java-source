package cn.offer;

import cn.common.ListNode;

/**
 * 题目：删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 地址：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-02 19:53
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode listNode = new ListNode();
        listNode.next = head;
        ListNode cur = head;
        ListNode pre = listNode;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return listNode.next;
    }

    public ListNode deleteNode2(ListNode head, int val) {

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 关键：如果没有找到要
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
