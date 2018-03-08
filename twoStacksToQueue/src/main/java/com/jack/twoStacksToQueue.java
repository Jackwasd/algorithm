package com.jack;
import java.util.Stack;

/**
 * 用两个栈形成一个队列，并且实现POP和PUSH操作
 * 先把元素全部放进栈s1，以stack2作为出栈，只要stack2不为空，就以
 * stack2的栈顶元素作为出栈元素，否则将stack1的栈顶元素装入stack2
 * 之后再以stack2的栈顶元素出栈
 */

public class twoStacksToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}