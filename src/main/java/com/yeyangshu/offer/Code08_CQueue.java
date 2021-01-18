package com.yeyangshu.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
public class Code08_CQueue {
    public Code08_CQueue() {

    }
    LinkedList<Integer> inStack = new LinkedList<>();
    LinkedList<Integer> outStack = new LinkedList<>();


    public void appendTail(int value) {
        inStack.add(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.add(inStack.removeFirst());
            }
        }
        return outStack.removeFirst();
    }

    public static void main(String[] args) {
        Code08_CQueue queue = new Code08_CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        queue.appendTail(5);
        System.out.println(queue.deleteHead());
    }
}
