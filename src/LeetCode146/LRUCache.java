package LeetCode146;

import java.util.HashMap;
import java.util.Map;

class DeList {
    public int key;
    public int value;
    public DeList before;
    public DeList next;

    public DeList(int key, int value) {
        this.key = key;
        this.value = value;
        before = null;
        next = null;
    }
}

public class LRUCache {
    int capacity;
    Map<Integer, DeList> map;
    DeList preHead;
    DeList postTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        preHead = new DeList(-1, -1);
        postTail = new DeList(-1, -1);
        preHead.next = postTail;
        postTail.before = preHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DeList node = map.get(key);
            node.before.next = node.next;
            node.next.before = node.before;
            preHead.next.before = node;
            node.next = preHead.next;
            preHead.next = node;
            node.before = preHead;
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DeList node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            node.before.next = node.next;
            node.next.before = node.before;
        } else {
            node = new DeList(key, value);
            map.put(key, node);
        }
        preHead.next.before = node;
        node.next = preHead.next;
        preHead.next = node;
        node.before = preHead;
        if (map.size() > capacity) {
            map.remove(postTail.before.key);
            DeList lruNode = postTail.before;
            postTail.before = lruNode.before;
            lruNode.before.next = postTail;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.get(2);
        obj.put(2, 6);
        obj.get(1);
        obj.put(1, 5);
        obj.put(1, 2);
        obj.get(1);
        obj.get(2);
    }
}
