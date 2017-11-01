package com.cnbo;

/**
 * 栈的简单实现（后进先出）
 * @author cnbo 2017/10/30
 */
public class MyStack {

    private MyLinkedList linkedList = new MyLinkedList();

    public void push(Object obj) {
        linkedList.addFirst(obj);
    }

    public Object peek() {
        return linkedList.get(0);
    }

    public Object pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    public int size() {
        return linkedList.size();
    }

}
