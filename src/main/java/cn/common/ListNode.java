package cn.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int... items) {

        ListNode listNode = new ListNode();
        if (items == null || items.length == 0) {
            return listNode;
        }
        ListNode tmp = listNode;
        for (int i = 0; i < items.length; i++) {
            if (i == 0) {
                listNode.val = items[i];
            } else {
                tmp.next = new ListNode(items[i]);
                tmp = tmp.next;
            }
        }
        return listNode;
    }
}
