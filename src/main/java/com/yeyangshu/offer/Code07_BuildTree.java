package com.yeyangshu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Code07_BuildTree {
    /**
     * 重建二叉树
     *
     * @param preOrder 前序遍历结果
     * @param inOrder  中序遍历结果
     * @return 重建的二叉树
     */
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preOrder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inOrder[i], i);
        }
        TreeNode root = buildTree(preOrder, 0, length - 1, inOrder, 0, length - 1, indexMap);
        return root;
    }

    public static TreeNode buildTree(int[] preOrder, int preOrderStart, int preOrderEnd,
                                     int[] inOrder, int inOrderStart, int inOrderEnd, Map<Integer, Integer> indexMap) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }
        int rootValue = preOrder[preOrderStart];
        TreeNode root = new TreeNode(rootValue);
        if (preOrderStart == preOrderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootValue);
            int leftNodes = rootIndex - inOrderStart;
            int rightNodes = inOrderEnd - rootIndex;
            TreeNode leftNode = buildTree(preOrder, preOrderStart + 1, preOrderStart + leftNodes, inOrder, inOrderStart, rootIndex - 1, indexMap);
            TreeNode rightNode = buildTree(preOrder, preOrderEnd - rightNodes + 1, preOrderEnd, inOrder, rootIndex + 1, inOrderEnd, indexMap);
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
