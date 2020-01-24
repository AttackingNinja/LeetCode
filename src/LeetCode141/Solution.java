package LeetCode141;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null)
                return false;
            else
                fast = fast.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
