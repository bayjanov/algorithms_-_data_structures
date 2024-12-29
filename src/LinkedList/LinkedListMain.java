package LinkedList;

public class LinkedListMain {
    public static void init() {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

//        list.reverse();
//        int[] array = list.toArray();

        System.out.println(list.getKthFromTheEnd(3));
    }
}

