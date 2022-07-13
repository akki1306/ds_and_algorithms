package lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int maxSize;
    LinkedList<Node> i;
    Map<String, Node> m;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 1;
        this.i = new LinkedList<>();
        this.m = new HashMap<>();
    }

    public void insertKeyValue(String key, int value) {
        // 1. present in the cache
        if (m.containsKey(key))
            m.get(key).setValue(value);
        else {
            if (m.size() == maxSize) {
                m.remove(i.getLast().getKey());
                i.removeLast();
            }

            Node n = new Node(key, value);
            i.addFirst(n);
            m.put(key, n);
        }
    }

    public int getValue(String key) {
        if (m.containsKey(key)) {
            i.addFirst(i.removeLast());
            return m.get(key).getValue();
        } else {
            return -1;
        }
    }

    public String mostRecentKey() {
        return i.getFirst().getKey();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValue("mango", 10);
        cache.insertKeyValue("apple", 20);
        cache.insertKeyValue("guava", 30);
        System.out.println("Most recent Key : " + cache.mostRecentKey());

        cache.insertKeyValue("banana", 20);

        if (cache.getValue("apple") == -1)
            System.out.println("apple doesnt exists.");

        if (cache.getValue("guava") == -1)
            System.out.println("guava doesnt exists.");

        if (cache.getValue("banana") == -1)
            System.out.println("banana doesnt exists.");

        if (cache.getValue("mango") == -1)
            System.out.println("mango doesnt exists");
    }
}
