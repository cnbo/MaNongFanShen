package com.cnbo;

/**
 * 二叉树的简单实现
 * @author cnbo 2017/10/30
 */
public class MyBinaryTree {

    private static class BinaryTreeNode {
        public int data;

        public BinaryTreeNode left;

        public BinaryTreeNode right;
    }

    private BinaryTreeNode parentNode;

    public void insert(int data) {
        BinaryTreeNode node = new BinaryTreeNode();
        node.data = data;
        if (parentNode == null) {
            parentNode = node;
            return;
        }

        if (node.data > parentNode.data && parentNode.left == null) {
            node.left = parentNode;
            parentNode = node;
            return;
        }

        insert(node, parentNode);
    }

    private void insert(BinaryTreeNode node, BinaryTreeNode parentNode) {
        BinaryTreeNode leftNode = parentNode.left;
        BinaryTreeNode rightNode = parentNode.right;

        if (node.data <= parentNode.data) {
            if (parentNode.left == null) {
                parentNode.left = node;
                return;
            }
            if (node.data > leftNode.data && leftNode.left == null) {
                node.left = leftNode;
                parentNode.left = node;
                return;
            }
            insert(node, leftNode);
        } else {
            if (parentNode.right == null) {
                parentNode.right = node;
                return;
            }

            insert(node, rightNode);
        }
    }

    public void printTree() {
        printTree(parentNode);
    }

    private void printTree(BinaryTreeNode node) {
        if (node.left != null) {
            printTree(node.left);
        }
        System.out.println(node.data);
        if (node.right != null) {
            printTree(node.right);
        }
    }

}
