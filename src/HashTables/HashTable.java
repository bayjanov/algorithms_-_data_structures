package HashTables;


import java.util.LinkedList;
import java.util.NoSuchElementException;

//   INTERVIEW QUESTION: Build/Construct HashTable.
public class HashTable {
    // Entry (KeyValuePair) class that grabs a key-value pair, so it should have two fields: key, value
    private class Entry {
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
        public int key;
        public String value;
    }

    // LinkedList<Entry>[] - we need to have a linkedList Array to store the items
    private LinkedList<Entry>[] entries = new LinkedList[5];

    private int hash(int key) {
        return key % entries.length;
    }

    // put(key, value)
    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }


    // get(key)
    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    // remove(k) removes the corresponding value in the table
    public void remove(int key) {
        Entry entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    // utils


    // getBucket
    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    // private getOrCreateBucket
    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        var bucket = entries[index];
        if(bucket == null)
            entries[index] = new LinkedList<>();

        return bucket;
    }

    // getEntry
    private Entry getEntry(int key) {
        LinkedList<Entry> bucket =  getBucket(key);
        if(bucket != null) {
            for(Entry entry : bucket) {
                if(entry.key == key)
                    return entry;
            }
        }

        return null;
    }

    // getPrimeLessThanTableSize Method for chaining collision handling  method
    private int getPrimeLessThanTableSize() {
        int table_size = entries.length;
        for(int primeCandidate = table_size-1; primeCandidate >= 0; primeCandidate--) {
            int squareRoot = (int) Math.floor(Math.sqrt(primeCandidate));
            boolean isPrime = true;
            for(int n = 2; n <= squareRoot; n++) {
                if(primeCandidate % n == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                return primeCandidate;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Entry> entry : entries) {
            if(entry != null) {
                for (Entry item : entry) {
                    sb.append("[" + item.key + ", " + item.value + "] ");
                }
            }
        }
        return sb.toString();
    }

    //  Print the linkedLists on index 0, 1, 2, 3, 4
    public void print() {
        for (LinkedList<Entry> entry : entries) {
            if(entry != null) {
                for (Entry item : entry) {
                    System.out.print("[" + item.key + ", " + item.value + "] ");
                }
            }
            System.out.println();
        }
    }
}
    // Collisions: chaining
    // [LL, LL, LL, LL ]
