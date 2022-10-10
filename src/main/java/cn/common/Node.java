package cn.common;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-10 12:35:56
 */
public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        val = val;
    }

    public Node(int val, Node left, Node right) {
        val = val;
        left = left;
        right = right;
    }
}
