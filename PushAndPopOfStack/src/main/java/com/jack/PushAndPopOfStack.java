package com.jack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 这道题的意思是以1,2,3,4,5之类的指定顺序进栈，但是每次进栈的时候，都可以选择出栈或者不出栈，不管最后栈里面还剩几个元素，
 * 剩余的元素都要接着以后进先出的顺序加到之前出栈的元素后面，以此形成的顺序作为一个弹出序列。所以只需新建一个虚拟
 * 栈，然后将元素按压入顺序压入，每次压入之后都比较栈顶元素是否和弹出序列的当前元素相同，相同的话则POP，直至最后，
 * 如果此时虚拟栈为空的话，则说明压入，弹出序列相吻合。
 */
public class PushAndPopOfStack {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(stack.peek() == popA[j]){
                stack.pop();
                j++;
                if(stack.isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }
}