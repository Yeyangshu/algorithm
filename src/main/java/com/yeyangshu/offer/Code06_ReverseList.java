package com.yeyangshu.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 1 使用Stack
 * 2 递归
 */
public class Code06_ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用Stack
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            arr[i] = stack.pop();
            i++;
        }
        return arr;
    }

    /**
     * 使用递归
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        List<Integer> res = new ArrayList<>();
        recursive(head, res);
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void recursive(ListNode head, List<Integer> res) {
        if (head == null) {
            return;
        }
        recursive(head.next, res);
        res.add(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        head.next = second;
        second.next = third;
        int[] reversePrint = reversePrint(head);
        System.out.println(reversePrint.toString());
        int[] reversePrint2 = reversePrint2(head);
        System.out.println(reversePrint2);
    }
}
