package cn.common;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-09 16:18
 **/
public class NodeRandom {
    public int val;
    public NodeRandom next;
    public NodeRandom random;

    public NodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
