package cn.linklist;

import cn.common.ListNode;
/**
 * 题目：两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 题目地址：https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author MaiShuRen
 * @version v1.0
 * @date 2020/12/23 23:54
 */
public class Leetcode2两数相加 {
    public ListNode addTwoNumbers(ListNode list1, cn.common.ListNode list2) {
        // 预先指针
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int x = list1 == null ? 0 : list1.val;
            int y = list2 == null ? 0 : list2.val;
            int sum = x + y + carry;
            // 十位数为进位
            carry = sum / 10;
            // 个位数为结果
            sum = sum % 10;
            current.next = new ListNode(sum);
            current = current.next;
            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return pre.next;
    }
}
