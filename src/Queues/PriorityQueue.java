package Queues;

import java.util.Arrays;

// Mosh's solution
public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if(isFull())
            extendArrayQueue();

        int insertionIndex = shiftItemsToInsert(item);
        items[insertionIndex] = item;
        count++;
    }

    public int remove() {
        if(isEmpty()) throw new IllegalStateException("Queue is empty!");
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int size() {
        return count;
    }
    // Util methods

    public int shiftItemsToInsert(int item) {
        int i;
        // shifting items
        for(i = count -1; i >= 0; i--) {
            if(items[i] > item)
                items[i+1] = items[i];
            else
                break;
        }
        return ++i;
    }

    private void extendArrayQueue() {
        int[] newItems = new int[(int) Math.floor(items.length * 1.5)];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
