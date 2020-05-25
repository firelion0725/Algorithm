package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class DesignCircularDeque {

    private int[] data;
    private int count;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDeque(int k) {
        data = new int[k];
        count = k;
        size = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            System.arraycopy(data, 0, data, 1, size);
            data[0] = value;
            size++;
            return true;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            data[size] = value;
            size++;
            return true;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            System.arraycopy(data, 1, data, 0, size - 1);
            size--;
            return true;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            data[size - 1] = -1;
            size--;
            return true;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[0];
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[size - 1];
        }

    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == count;
    }

}
