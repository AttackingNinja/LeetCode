package LeetCode61;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode beforeForward = null;
        ListNode forward = head;
        ListNode backward = head;
        if (forward != null && k != 0) {
            int count = 1;
            while (count < k) {
                backward = backward.next;
                if (backward == null)
                    break;
                count++;
            }
            if (backward == null) {
                backward = head;
                k = k % count;
                if (k == 0)
                    return forward;
                count = 1;
                while (count < k) {
                    backward = backward.next;
                    count++;
                }
            }
            while (backward.next != null) {
                beforeForward = forward;
                forward = forward.next;
                backward = backward.next;
            }
            if (beforeForward == null) {
                return head;
            }
            beforeForward.next = null;
            backward.next = head;
        }
        return forward;
    }
}
