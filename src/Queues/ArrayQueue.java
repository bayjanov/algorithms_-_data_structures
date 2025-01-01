package Queues;

import java.util.Arrays;

public class ArrayQueue {
    private int front = 0;
    private int rear;
    private int size;
    private int count = 0;
    private int[] items;

    public ArrayQueue(int size) {
        items = new int[size];
        this.size = size;
    }

    // enqueue
    public void enqueue(int item) {
        if(isFull()) throw new IllegalStateException();
        if(isEmpty()) {
            front = rear = count;
        }
        rear++;
        items[count++] = item;
    }

    // dequeue
    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();
        count--;
        return items[front++];
    }

    // peek
    public int peek() {
        if(isEmpty()) throw new IllegalStateException();
        return items[front];
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }
    // isFull
    public boolean isFull() {
        return count == size;
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(items, front, rear);
        return Arrays.toString(content);
    }
}
