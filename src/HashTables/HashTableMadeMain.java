package HashTables;

public class HashTableMadeMain {
    public static void init() {
        HashTable hashTable = new HashTable();

        hashTable.put(1, "Value on key 1");
        hashTable.put(3, "Value on key 3");
        hashTable.put(11, "Value on key 11");
        hashTable.put(11, "Value on key 11 Rewritten");
        System.out.println(hashTable);


    }
}
