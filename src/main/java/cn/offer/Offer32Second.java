package cn.offer;

import cn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 提示：
 * 节点总数 <= 1000
 * <p>
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-10-07 23:22
 **/
public class Offer32Second {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        } else {
            return res;
        }
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
