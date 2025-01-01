package Queues;

import java.util.Arrays;

public class AQ {
    private int[] items;
    private int count;
    private int rear;
    private int front;

    public AQ(int capacity) {
        items =  new int[capacity];
    }

    public void enqueue(int item) {
        if(isFull()) throw new IllegalStateException();
        // Linear array
//        items[rear++] = item;

        // Circular array Method:
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        int item =  items[front];
        // Linear array
//        items[front++] = 0;

        // Circular array Method:
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    // Util methods

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }


}
