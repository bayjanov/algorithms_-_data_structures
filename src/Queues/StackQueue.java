package Queues;

import java.util.Arrays;

public class StackQueue {
    // ======================== INTERVIEW QUESTION: Implement a queue using Stacks =====================================
    // Hint: we can use 2 stacks
    private static class Stack {
        private int[] stack;
        private int count;

        public Stack() {
            stack = new int[5];
        }

        public void push(int item) {
            if(isFull()) stack = extend();
            stack[count++] = item;
        }

        public int pop() {
            if(isEmpty()) throw new IllegalStateException();
            return stack[--count];
        }

        public int peek() {
            if(isEmpty()) throw new IllegalStateException();
            return stack[count-1];
        }


        // Util methods
        public boolean isFull() {
            return count == stack.length;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int[] extend() {
            int[] newItems = new int[(int) (Math.floor(stack.length * 1.5))];
            for (int i = 0; i < count; i++) {
                newItems[i] = stack[i];
            }
            return newItems;
        }

        public int size() {
            return count;
        }

        @Override
        public String toString() {
            int[] content = Arrays.copyOfRange(stack, 0, count);
            return Arrays.toString(content);
        }
    }

    Stack normal = new Stack();
    Stack reversed = new Stack();

    public void enqueue(int item) {
        normal.push(item);
    }

    public int dequeue() {
        reversed = reverseStack(normal);
        int frontOfQueue = reversed.pop();
        normal = reverseStack(reversed);
        return frontOfQueue;
    }

    public int size() {
        return normal.size();
    }

    // util methods

    private Stack reverseStack(Stack stack) {
        Stack reversedStack = new Stack();
        int length = stack.size();
        for(int i = 0; i < length; i++) {
            reversedStack.push(stack.pop());
        }
        return reversedStack;
    }

    @Override
    public String toString() {
        return normal.toString();
    }

}
