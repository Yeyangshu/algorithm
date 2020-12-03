package com.yeyangshu.c02_datastructure;

/**
 * 单向链表、双向链表
 * 练习：单链表和双链表如何反转
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2020/12/3 22:47
 */
public class DataStructure01_LinkedList_ReverseList {

    /**
     * 单向链表节点结构
     */
    public static class Node {
        // 数据存储
        public int value;
        // 下一个节点
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 双向链表节点结构
     */
    public static class DoubleNode {
        // 数据存储
        public int value;
        // 上一个节点
        public DoubleNode last;
        // 下一个节点
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 翻转单向链表
     * head
     * a  ->  b  ->  c  ->  null
     * c  ->  b  ->  a  ->  null
     *
     * @param head
     * @return
     */
    public static Node reverseLinedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
