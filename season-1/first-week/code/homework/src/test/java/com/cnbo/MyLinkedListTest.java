package com.cnbo;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MyLinkedListTest extends TestCase {

    private MyLinkedList linkedList;

    public void setUp() throws Exception {
        linkedList = new MyLinkedList();
    }

    public void tearDown() throws Exception {
        linkedList = null;
    }

    /**
     * 测试尾插法
     * @throws Exception
     */
    public void testAdd() throws Exception {
        for (int i = 0; i < 150; i++) {
            linkedList.add(new Integer(i));
        }

        Assert.assertEquals(140, linkedList.get(140));
    }

    /**
     * 测试头插法
     * @throws Exception
     */
    public void testAddFirst() throws Exception {
        for (int i = 0; i < 150; i++) {
            linkedList.addFirst(new Integer(i));
        }

        Assert.assertEquals(149, linkedList.get(0));
    }

    /**
     * 测试按 index 插入
     * @throws Exception
     */
    public void testAdd1() throws Exception {
        for (int i = 0; i < 150; i++) {
            linkedList.add(i, new Integer(i));
        }

        Assert.assertEquals(100, linkedList.get(100));
    }

    public void testGet() throws Exception {
        for (int i = 0; i < 4; i++) {
            linkedList.add(i, new Integer(i));
        }

        for (int i = 0; i < linkedList.size(); i++) {
            Assert.assertEquals(i, linkedList.get(i));
        }

        Assert.assertNull(linkedList.get(linkedList.size() + 20));
        Assert.assertNull(linkedList.get(-1));
    }

    public void testRemove() throws Exception {
        for (int i = 0; i < 40; i++) {
            linkedList.add(i, new Integer(i));
        }
        Assert.assertEquals(30, linkedList.remove(30));
        Assert.assertEquals(31, linkedList.get(30));
        Assert.assertNull(linkedList.remove(-1));
    }

    public void testRemoveFirst() throws Exception {
        for (int i = 0; i < 20; i++) {
            linkedList.add(i, new Integer(i));
        }
        for (int i = 0; i < linkedList.size(); i++) {
            Assert.assertEquals(i, linkedList.removeFirst());
        }
    }

    public void testRemoveLast() throws Exception {
        for (int i = 0; i < 15; i++) {
            linkedList.add(i , new Integer(i));
        }
        while (linkedList.size() > 0) {
            Assert.assertEquals(linkedList.get(linkedList.size() - 1), linkedList.removeLast());
        }
    }

    public void testSize() throws Exception {
        for (int i = 0; i < 120; i++) {
            linkedList.add(i, new Integer(i));
        }
        Assert.assertEquals(120, linkedList.size());
    }

}