package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueMain {
    public static void init() {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        System.out.println(queue);
//        reverse(queue);
//        System.out.println(queue);


        // Self made Queue
//        ArrayQueue queue = new ArrayQueue(5);
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(30);
//        queue.enqueue(30);
//        queue.enqueue(30);
//        System.out.println(queue.peek());
////        reverse(queue);
////        int front = queue.dequeue();
////        System.out.println(front);
//        System.out.println(queue);

    // ============================================ MOSH's ArrayQueue AQ =======================================
//        AQ que = new AQ(5);
//        que.enqueue(10);
//        que.enqueue(20);
//        que.enqueue(30);
//        System.out.println(que);
//        que.dequeue();
//        int front = que.dequeue();
//        System.out.println(front);
//        System.out.println(que);
//

    // =============================== INTERVIEW QUESTION: Implement queue using Stacks ===============================
//        StackQueue stackQueue = new StackQueue();
//        stackQueue.enqueue(10);
//        stackQueue.enqueue(20);
//        stackQueue.enqueue(30);
////        System.out.println(stackQueue);
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        int front = stackQueue.dequeue();
//        System.out.println(front);
//        System.out.println(stackQueue);




    // =============================== PRIORITY QUEUE: Array Implementation ===============================
//        ArrayPriorityQueue pq = new ArrayPriorityQueue(5); // My implementaion
        PriorityQueue pq =  new PriorityQueue(); // Mosh's implementation
        pq.add(30);
        pq.add(10);
        pq.add(50);
        pq.add(40);
//        pq.enqueue(20);
//        pq.add(25);

//        System.out.println(pq.size());
        int front = pq.remove();
        System.out.println(front);
        System.out.println(pq);



    }

    // ============================== INTERVIEW QUESTION: Reverse a queue =================================
    public static void reverse(Queue<Integer> queue) {
        // add, remove, isEmpty
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.empty())
            queue.add(stack.pop());
    }
}
