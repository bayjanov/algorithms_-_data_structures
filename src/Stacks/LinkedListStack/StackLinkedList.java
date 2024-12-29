package Stacks.LinkedListStack;

import java.util.Arrays;

public class StackLinkedList {
    private class Node {
        int value;
        Node next;
        public Node(int value) { this.value = value; }
    }

    private Node first;
    private Node last;
    private int size;


   // push
    public void push(int item) {
        Node node = new Node(item);

        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int pop() {
        if(isEmpty()) throw new IllegalStateException();

        int top = last.value;
        if(isFirstLast()) first = last = null;
        else {
            Node current = first;
            while(current != last) {
                if(current.next == last) {
                    last = current;
                    last.next = null;
                    break;
                }
                current = current.next;
            }
        }
        size--;
        return top;
    }

    public int peek() {
        return last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFirstLast() {
        return first == last;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while(current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
