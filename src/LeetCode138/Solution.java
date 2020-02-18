package LeetCode138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        next = null;
        random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        Node copyHead = null;
        Node cur = null;
        Node p = head;
        Map<Node, Integer> map = new HashMap<>();
        int count = 0;
        while (p != null) {
            map.put(p, count);
            count++;
            p = p.next;
        }
        p = head;
        Node[] nodes = new Node[count];
        count = 0;
        while (p != null) {
            if (copyHead == null) {
                copyHead = new Node(p.val);
                cur = copyHead;
            } else {
                cur.next = new Node(p.val);
                cur = cur.next;
            }
            nodes[count] = cur;
            count++;
            p = p.next;
        }
        p = head;
        cur = copyHead;
        while (p != null) {
            if (p.random != null) {
                int index = map.get(p.random);
                Node q = nodes[index];
                cur.random = q;
            }
            cur = cur.next;
            p = p.next;
        }
        return copyHead;
    }
}
