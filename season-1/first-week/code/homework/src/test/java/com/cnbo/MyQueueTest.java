package com.cnbo;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MyQueueTest extends TestCase {

    private MyQueue queue;

    public void setUp() throws Exception {
        queue = new MyQueue();
    }

    public void tearDown() throws Exception {
        queue = null;
    }

    public void testEnQueue() throws Exception {
        for (int i = 0; i < 20; i++) {
            queue.enQueue(new Integer(i));
        }

        Assert.assertEquals(0, queue.deQueue());
    }

    public void testDeQueue() throws Exception {
        for (int i = 0; i < 20; i++) {
            queue.enQueue(new Integer(i));
        }
        for (int i = 0; i < 20; i++) {
            Assert.assertEquals(i, queue.deQueue());
        }
    }

    public void testIsEmpty() throws Exception {
        Assert.assertTrue(queue.isEmpty());
        for (int i = 0; i < 3; i++) {
            queue.enQueue(new Integer(i));
        }
        Assert.assertEquals(false, queue.isEmpty());
        for (int i = 0; i < 3; i++) {
            queue.deQueue();
        }
        Assert.assertTrue(queue.isEmpty());
    }

    public void testSize() throws Exception {
        for (int i = 100; i < 300; i++) {
            queue.enQueue(new Integer(i));
        }

        Assert.assertEquals(200, queue.size());
    }

}