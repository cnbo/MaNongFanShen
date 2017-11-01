package com.cnbo;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;

public class MyArrayListTest extends TestCase {

    private MyArrayList myArrayList;

    public void setUp() throws Exception {
        myArrayList = new MyArrayList();
    }

    public void tearDown() throws Exception {
        myArrayList = null;
    }

    public void testAdd() throws Exception {
        myArrayList.add(new Integer(3));
        Assert.assertEquals(3, myArrayList.get(0));
    }

    public void testAdd1() throws Exception {
        myArrayList.add(3, new Integer(4));
        myArrayList.add(5, new Integer(6));
        Assert.assertEquals(6, myArrayList.get(1));
    }

    public void testGet() throws Exception {
        for (int i = 0; i < 50; i++) {
            myArrayList.add(new Integer(i));
        }
        Assert.assertEquals(40, myArrayList.get(40));
        Assert.assertEquals(49, myArrayList.get(51));
        Assert.assertNull(myArrayList.get(-1));
    }

    public void testRemove() throws Exception {
        for (int i = 0; i < 50; i++) {
            myArrayList.add(new Integer(i));
        }
        Assert.assertEquals(40, myArrayList.remove(40));
        Assert.assertNull(myArrayList.remove(-1));
        Assert.assertNull(myArrayList.remove(49));
    }

    public void testSize() throws Exception {
        for (int i = 0; i < 50; i++) {
            myArrayList.add(new Integer(i));
        }
        Assert.assertEquals(50, myArrayList.size());
    }

}