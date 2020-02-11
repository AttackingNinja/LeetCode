package LeetCode83;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode p = head;
            ListNode q = p.next;
            while (q != null) {
                if (p.val != q.val) {
                    p.next = q;
                    p = p.next;
                }
                q = q.next;
            }
            p.next = null;
        }
        return head;
    }
}
