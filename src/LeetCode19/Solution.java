package LeetCode19;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode beforeSlow = null;
        ListNode fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            beforeSlow = slow;
            slow = slow.next;
        }
        if (beforeSlow != null)
            beforeSlow.next = slow.next;
        else
            head = head.next;
        return head;
    }
}
