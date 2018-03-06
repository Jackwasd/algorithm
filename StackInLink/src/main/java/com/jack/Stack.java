package com.jack;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 将栈用链表的形式实现
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item>{
        private Node first;
        private int N;
        private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    //向栈顶下压一个新的元素
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    //从栈顶删除一个新的元素
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    //实现迭代器部分
    //Iterable接口中有一个Iterator<T> Iterator(),会产生一个迭代器对象
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext() {
        return current != null;
        }
        public void remove(){};
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
