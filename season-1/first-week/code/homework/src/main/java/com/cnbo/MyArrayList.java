package com.cnbo;

import java.util.Arrays;

/**
 * @author cnbo 2017/10/27
 * 简易 ArrayList 实现
 */
public class MyArrayList {

    private int size = 0;

    private Object[] elementData = new Object[10];

    private Object[] grow(Object[] src) {
        if (size == src.length) {
            src = Arrays.copyOf(src, size + size / 4);
        }

        return src;
    }

    public void add(Object obj) {
        elementData = grow(elementData);
        elementData[size++] = obj;
    }

    public void add(int index, Object obj) {
        elementData = grow(elementData);
        if (index < 0) {
            index = 0;
        }
        if (index >= size) {
            elementData[size++] = obj;
        } else {
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = obj;
            size++;
        }
    }

    public Object get(int index) {
        if (index < 0 || size == 0) {
            return null;
        }
        if (index >= size) {
            index = size - 1;
        }

        return elementData[index];
    }

    public Object remove(int index) {
        if (index >= size || index < 0 || size == 0) {
            return null;
        }
        Object result = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
        size--;

        return result;
    }

    public int size() {
        return size;
    }
}
