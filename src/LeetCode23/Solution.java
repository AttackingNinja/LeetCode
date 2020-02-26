package LeetCode23;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Map<Integer, Queue<ListNode>> map = new HashMap<>();
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.offer(head.val);
                if (map.containsKey(head.val)) {
                    map.get(head.val).offer(head);
                } else {
                    Queue<ListNode> queue = new LinkedList<>();
                    queue.offer(head);
                    map.put(head.val, queue);
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode node = map.get(priorityQueue.poll()).poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                node = node.next;
                priorityQueue.offer(node.val);
                if (map.containsKey(node.val)) {
                    map.get(node.val).offer(node);
                } else {
                    Queue<ListNode> queue = new LinkedList<>();
                    queue.offer(node);
                    map.put(node.val, queue);
                }
            }

        }
        return preHead.next;
    }
}
