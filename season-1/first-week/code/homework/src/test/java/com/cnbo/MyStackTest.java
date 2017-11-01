package com.cnbo;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MyStackTest extends TestCase {

    private MyStack stack;

    public void setUp() throws Exception {
        stack = new MyStack();
    }

    public void tearDown() throws Exception {
        stack = null;
    }

    public void testPush() throws Exception {
        for (int i = 100; i < 200; i++) {
            stack.push(new Integer(i));
        }
        Assert.assertEquals(199, stack.peek());
    }

    public void testPeek() throws Exception {
        for (int i = 100; i < 200; i++) {
            stack.push(new Integer(i));
        }
        Assert.assertEquals(199, stack.peek());
    }

    public void testPop() throws Exception {
        for (int i = 100; i < 200; i++) {
            stack.push(new Integer(i));
        }
        for (int i = 199; i >= 100; i--) {
            Assert.assertEquals(i, stack.pop());
        }
    }

    public void testIsEmpty() throws Exception {
        Assert.assertTrue(stack.isEmpty());
        stack.push(new Integer(1));
        Assert.assertEquals(false, stack.isEmpty());
        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }

    public void testSize() throws Exception {
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }
        Assert.assertEquals(10, stack.size());
        stack.pop();
        Assert.assertEquals(9, stack.size());
    }

}