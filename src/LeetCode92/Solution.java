package LeetCode92;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseBetweenByIteration(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        if (m != n) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode preSlow = preHead;
            int count = 0;
            while (count < n - m) {
                fast = fast.next;
                count++;
            }
            count++;
            while (count < n) {
                fast = fast.next;
                preSlow = slow;
                slow = slow.next;
                count++;
            }
            while (slow != fast) {
                ListNode postSlow = slow.next;
                preSlow.next = slow.next;
                slow.next = fast.next;
                fast.next = slow;
                slow = postSlow;
            }
        }
        return preHead.next;
    }

    ListNode last = null;

    ListNode recurse(ListNode node, int m, int n, int count) {
        if (count == n) {
            last = node;
            return node.next;
        }
        ListNode afterLast = recurse(node.next, m, n, count + 1);
        if (count >= m) {
            node.next.next = node;
            node.next = afterLast;
        }
        if (count == m - 1) {
            node.next = last;
        }
        return afterLast;
    }

    public ListNode reverseBetweenByRecurse(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        if (m != n) {
            recurse(preHead, m, n, 0);
        }
        return preHead.next;
    }
}
