package Queues;

import java.util.Arrays;

public class ArrayPriorityQueue {
    private int[] queue;
    private int count;

    public ArrayPriorityQueue(int capacity) {
        queue = new int[capacity];
    }

    // enqueue
    public void add(int item) {
        if (isFull())
            throw new IllegalStateException("Cannot enqueue new element: queue is full.");

        // Start from the "end" of the used portion.
        int i = count - 1;

        // Shift larger items to the right
        while (i >= 0 && queue[i] > item) {
            queue[i + 1] = queue[i];
            i--;
        }

        // Insert the new item
        queue[i + 1] = item;
        count++;
    }
    // dequeue
    public int remove() {
        if(isEmpty()) throw new IllegalStateException("Queue is empty.");
        return queue[--count];
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException("Queue is empty.");
        return queue[count-1];
    }

    // size
    public int size() {
        return count;
    }

    // isEmpty
    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return queue.length == count;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    // shift items?

    // Edge cases:
    // What if array is empty?
    // What if it has a single item?
    // What if it has an even number of items?
    // what if it gets full?
}
