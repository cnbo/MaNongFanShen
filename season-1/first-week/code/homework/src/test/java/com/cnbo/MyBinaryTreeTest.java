package com.cnbo;

import junit.framework.TestCase;

public class MyBinaryTreeTest extends TestCase {

    private MyBinaryTree tree;

    private int[] testNums;

    public void setUp() throws Exception {
        tree = new MyBinaryTree();
        testNums = new int[]{12, 2, 3, 4, 2, 3, 4, 11, 8, 8, 20, 10, 11, 12, 7, 6};
    }

    public void tearDown() throws Exception {
        tree = null;
        testNums = null;
    }

    public void testPrintTree() throws Exception {
        for (int i = 0; i < testNums.length; i++) {
            tree.insert(testNums[i]);
        }

        tree.printTree();
    }

}