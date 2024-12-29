package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;


    // addLast
    public void addLast(int item) {
        Node node =  new Node(item);

        if(isEmpty())
            last = first = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // addFirst
    public void addFirst(int item) {
        Node node = new Node(item);
        node.value = item;

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    // removeFirst
    public void removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last)
            first =  last = null;
        else {
            Node second = first.next;
            first.next = null;
            first =  second;
        }
        size--;
    }

    // removeLast
    public void removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if(first == last)
            first = last = null;
        else {
            Node current = first;
            while(current != null) {
                if(current.next == last)
                {
                    last = current;
                    last.next = null;
                    break;
                }
                current = current.next;
            }
        }
        size--;
    }

//    private Node getPrevious(Node node) {
//
//    }

    // contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // indexOf
    public int indexOf(int item) {
        Node current = first;
        int index = 0;
        while(current != null) {
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
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

//    public void reverse() {
//        int[] array = toArray();
//
//        Node current = first;
//            for (int i = array.length - 1; i >= 0; i--) {
//                if (current != null) {
//                    current.value = array[i];
//                    current = current.next;
//                }
//            }
//    }

    public void reverse() {
        if (isEmpty()) return;

        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if(isEmpty()) throw new IllegalStateException();
        Node pointerKth = first;
        Node pointerLast = first;

        for (int i = 0; i < k-1; i++) {
            pointerLast = pointerLast.next;
            if (pointerLast == null) {
                throw new IllegalArgumentException(); // this is when we don't know the size of the linkedList
            }
        }

        while(pointerLast != last) {
            pointerKth = pointerKth.next;
            pointerLast = pointerLast.next;
        }

        return pointerKth.value;
    }
}
