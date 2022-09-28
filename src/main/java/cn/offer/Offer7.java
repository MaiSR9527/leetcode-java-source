package cn.offer;

import cn.common.TreeNode;

import java.util.Arrays;

/**
 * 由前序和中序遍历重建二叉树
 * <p>
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假
 * 设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：先找出根节点，然后利用递归方法构造二叉树
 * <p>
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * @author MaiShuRen
 * @site: https://www.maishuren.top
 * @since 2020-09-10
 */
public class Offer7 {
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = rebuildBinaryTree(preOrder, inOrder);
        TreeNode treeNode2 = rebuildBinaryTree2(preOrder, inOrder);
        System.out.println(treeNode);
        System.out.println(treeNode2);
    }

    /**
     * 递归传入数组的拷贝
     *
     * @param preOrder 前序遍历
     * @param inOrder  中序遍历
     * @return 二叉树
     */
    public static TreeNode rebuildBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null | preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        if (preOrder.length != inOrder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        for (int i = 0; i < preOrder.length; i++) {
            if (preOrder[0] == inOrder[i]) {
                root.left = rebuildBinaryTree(Arrays.copyOfRange(preOrder, 1, i + 1),
                        Arrays.copyOfRange(inOrder, 0, i));
                root.right = rebuildBinaryTree(Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
                        Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
            }
        }

        return root;
    }

    public static TreeNode rebuildBinaryTree2(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }
        return helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.
                length - 1);
    }

    private static TreeNode helper(int[] preOrder, int preL, int preR, int[] inOrder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = preOrder[preL];
        int index = 0;
        while (index <= inR && inOrder[index] != rootVal) {
            index++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preOrder, preL + 1, preL - inL + index, inOrder,
                inL, index);
        root.right = helper(preOrder, preL - inL + index + 1, preR, inOrder,
                index + 1, inR);
        return root;
    }

}
