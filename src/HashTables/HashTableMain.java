package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public  class HashTableMain {
    public static void init() {
        // util.Map
        Map<Integer, String> map = new HashMap<>();  // Map is an interface and HashMap is an implementation of this interface

        // put/insert add entry
        map.put(1, "Bakhti");
        map.put(2, "John");
        map.put(3, "Mary");
        map.put(3, "Marian"); // overrides the previous value attached to key 3.
        map.put(null, null); // in HashMap we can have both NULL keys and NULL values.

        // remove
        map.remove(null); // by removing the key we will remove the entire KEY-VALUE pair

        // get
        String value = map.get(3);  // we get the value by key

        // check the existence of key
        map.containsKey(3);         // O(1) because we can directly access the key by memory address (the key)
        map.containsValue("Mosh");  // O(n) because it iterates over all the values array.

//        // iterating over the HashMap.
//        // We can iterate either by
//        // entrySet
//        for(Entry<Integer, String> item: map.entrySet()) {
//            System.out.println(item);
//        }
//
//        // or keySet
//        for (int key : map.keySet()) {
//            System.out.println(key);
//        }

        System.out.println(firstNonRepeatedChar("a green apple"));
    }


    // =========================== INTERVIEW QUESTION: Find first non-repeated character ===========================
    public static char firstNonRepeatedChar(String input) {
        char[] charArray = input.toLowerCase().toCharArray();
        Map<Character, Integer> map =  new HashMap<>();
        for(char ch : charArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map.keySet());

        for(char ch : charArray) {
            if(map.get(ch) == 1) {
                return ch;
            }
        }
        return '\0'; // return null character if none found
    }

}
