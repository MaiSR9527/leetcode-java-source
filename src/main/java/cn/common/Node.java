package cn.common;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-09 16:18
 **/
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
