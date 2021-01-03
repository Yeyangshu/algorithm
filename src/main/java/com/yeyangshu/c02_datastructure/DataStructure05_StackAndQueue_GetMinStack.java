package com.yeyangshu.c02_datastructure;

import java.util.Stack;

/**
 * 返回栈中最小元素
 * - pop、push、getMin 操作的时间复杂度都是 O(1)
 * - 设计的栈类型可以使用现成的栈结构
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2020/12/6 11:03
 */
public class DataStructure05_StackAndQueue_GetMinStack {

    public static class MyStack1 {
        /** 数据栈 */
        private Stack<Integer> stackData;
        /** 最小栈 */
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**
         * 压栈
         *
         * @param newNum
         */
        public void push(int newNum) {
            // 最小栈为空，压栈
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            // 新元素比最小栈栈顶小，压新元素
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            // 数据栈不比较，直接压栈
            this.stackData.push(newNum);
        }

        /**
         * 弹栈
         *
         * @return 数据
         */
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            // 弹出数据栈栈顶
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                // 弹出最小栈栈顶
                this.stackMin.pop();
            }
            return value;
        }

        /**
         * 返回最小栈栈顶元素（就是元素最小值）
         *
         * @return 元素最小值
         */
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
}
