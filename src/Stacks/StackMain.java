package Stacks;

import Stacks.LinkedListStack.StackLinkedList;

public class StackMain {
    public static void initBaseArray() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
//        stack.pop();
//        stack.push(40);
//        stack.push(50);
//        stack.push(60); // StackOverflowError when stack is full

        System.out.println(stack.peek());
    }

    public static void initLinkedListStack() {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
