package cn.offer;

import cn.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 题目描述：输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：借助栈实现，或使用递归的方法。
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-09-10
 */
public class Offer6 {
    public static void main(String[] args) {
        System.out.println("=========使用栈打印==========");
        System.out.println(printLinkListTailToHeadByStack(ListNode.buildListNode(1, 2, 4, 5, 6, 7, 8, 9, 12, 14, 55)));
        System.out.println("=========使用递归打印==========");
        System.out.println(printLinkListTailToHeadByRecursion(ListNode.buildListNode(1, 2, 4, 5, 6, 7, 8, 9, 12, 14, 55)));
    }

    public static List<Integer> printLinkListTailToHeadByStack(ListNode listNode) {

        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static List<Integer> printLinkListTailToHeadByRecursion(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        if (listNode != null) {
            if (listNode.next != null) {
                result = printLinkListTailToHeadByRecursion(listNode.next);
            }
            result.add(listNode.val);
        }
        return result;
    }
}
