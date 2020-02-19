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
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        cur.next = p == null ? q : p;
        return preHead.next;
    }
}
