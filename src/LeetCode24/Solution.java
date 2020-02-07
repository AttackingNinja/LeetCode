package LeetCode24;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode pBefore = null;
        ListNode pAfter = p.next;
        head = pAfter == null ? head : pAfter;
        while (p != null && pAfter != null) {
            p.next = pAfter.next;
            pAfter.next = p;
            if (pBefore != null) {
                pBefore.next = pAfter;
            }
            pBefore = p;
            p = p.next;
            if (p != null) {
                pAfter = p.next;
            }
        }
        return head;
    }
}
