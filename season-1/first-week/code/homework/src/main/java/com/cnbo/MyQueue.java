package com.cnbo;

/**
 * 队列的简单实现（先进先出）
 * @author cnbo 2017/10/30
 */
public class MyQueue {

    private MyLinkedList linkedList = new MyLinkedList();

    public void enQueue(Object obj) {
        linkedList.add(obj);
    }

    public Object deQueue() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    public int size() {
        return linkedList.size();
    }

}
