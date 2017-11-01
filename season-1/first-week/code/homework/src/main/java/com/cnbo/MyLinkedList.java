package com.cnbo;

/**
 * @author cnbo 2017/10/27
 * LinkedList 简易实现
 */
public class MyLinkedList {

    private static class Node {
        public Object data;

        public Node next;
    }

    private Node first;

    private Node last;

    private int size = 0;

    /**
     * 尾插法
     * @param obj
     */
    public void add(Object obj) {
        if (first == null) {
            addFirst(obj);
            return;
        }

        Node node = new Node();
        node.data = obj;
        last.next = node;
        last = node;
        size++;
    }

    /**
     * 头插法
     */
    public void addFirst(Object obj) {
        Node node = new Node();
        node.data = obj;
        node.next = first;
        if (first == null) {
            last = node;
        }
        first = node;
        size++;
    }

    /**
     * 如果 index < 0，则使用头插法 addFirst(obj);
     * 如果 index >= size，则使用尾插法 add(obj);
     * @param index
     * @param obj
     */
    public void add(int index, Object obj) {
        if (index < 0) {
            addFirst(obj);  //头插法
        } else if (index >= size) {
            add(obj);   //尾插法
        } else {
            Node newNode = new Node();
            newNode.data = obj;

            Node tempNode = first;
            while (index-- > 1) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            size++;
        }
    }

    public Object get(int index) {
        if (index < 0 || size == 0 || index >= size) {
            return null;
        }
        Node tempNode = first;
        while (index-- > 0) {
            tempNode = tempNode.next;
        }

        return tempNode.data;
    }

    public Object remove(int index) {
        if (index < 0 || size == 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }

        Node preNode = first;
        Node deleteNode = preNode.next;
        while (index-- > 1) {
            preNode = deleteNode;
            deleteNode = preNode.next;
        }
        preNode.next = deleteNode.next;
        Object result = deleteNode.data;
        deleteNode = null;
        size--;

        return result;
    }

    public Object removeFirst() {
        size--;
        if (first == null) {
            return null;
        }
        Object result = first.data;
        first = first.next;

        return result;
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

}
