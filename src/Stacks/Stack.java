package Stacks;

import java.util.Arrays;

public class Stack {
    private int count;
    private int[] stack;
    // Stack
    public Stack(){
        stack = new int[5];
    }

    // push
    public void push(int elem) {
        if(stack.length == count)
            throw new StackOverflowError();
        stack[count++] = elem;
    }

    // pop
    public int pop() {
        if(count == 0) throw new IllegalStateException();

        return stack[--count];
//        int top = stack[count-1];
//        int[] newStack = new int[count-1];
//        for (int i = 0; i < count - 1; i++) {
//            newStack[i] = stack[i];
//        }
//
//        stack = newStack;
//        return top;
    }

    // peek
    public int peek() {
        if (count == 0) throw new IllegalStateException();
        return stack[count-1];
    }

    // isEmpty
    public boolean isEmpty() {
        return count == 0;
    }


    // return a content of this array as String
    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }
}
