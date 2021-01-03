package com.yeyangshu.c02_datastructure;

/**
 *  使用双向链表实现栈和队列
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2020/12/6 10:33
 */
public class DataStructure03_StackAndQueue_DoubleEndsQueueToStackAndQueue {

    /**
     * 双向链表节点
     *
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 队列
     *
     * @param <T>
     */
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        /**
         * 头部增加节点
         *
         * @param value
         */
        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        /**
         * 尾部增加节点
         *
         * @param value
         */
        public void addFromBottom(T value) {

        }

        /**
         * 头部弹出节点
         *
         * @return
         */
        public T popFromHead() {
            return null;
        }

        /**
         * 尾部弹出节点
         *
         * @return
         */
        public T popFromBottom() {
            return null;
        }
    }
}
