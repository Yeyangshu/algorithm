package com.yeyangshu.zuo.c02_datastructure;

/**
 * 删除给定值的链表
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2020/12/3 23:10
 */
public class DataStructure02_LinkedList_DeleteGivenValue {

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

    // head = removeValue(head, 2);
    public static Node removeValue(Node head, int num) {
        // 如果删除正好是头部，首先head来到第一个不需要删的位置
        // 举例 3 -> 3 -> 3 -> 4 -> 3 -> 3 -> 7，头部首先来到4的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 1 ) head == null
        // 2 ) head != null
        // 保存头部节点位置
        Node pre = head;
        // 临时变量
        Node cur = head;
        // 4 -> 3 -> 3 -> 7
        // 4 -> 3 -> 7
        // 4 -> 7
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
