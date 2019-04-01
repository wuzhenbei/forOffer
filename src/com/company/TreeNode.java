package com.company;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) { this.val = val; }
    // 前序中序构造二叉树
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public static TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                root.left = buildTreeCore(preorder, preStart+1, preStart+i-inStart, inorder, inStart, i-1);
                root.right = buildTreeCore(preorder, preStart+i-inStart+1, preEnd, inorder, i+1, inEnd);
                break;
            }
        }
        return root;
    }
    // 前序遍历
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    // qian序遍历
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val);
            curr = curr.right;
        }

    }
}
