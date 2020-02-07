package LeetCode21;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            ListNode pBefore = null;
            ListNode qBefore = null;
            while (p != null && p.val <= q.val) {
                pBefore = p;
                p = p.next;
            }
            if (pBefore != null) {
                pBefore.next = q;
            }
            while (p != null && q != null && q.val <= p.val) {
                qBefore = q;
                q = q.next;
            }
            if (qBefore != null) {
                qBefore.next = p;
            }
        }
        return head;
    }
}
