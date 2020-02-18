package LeetCode2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = null;
        while (p != null && q != null) {
            int num1 = p.val;
            int num2 = q.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = new ListNode(sum % 10);
                cur = head;
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            p = p.next;
            q = q.next;
        }
        ListNode k = p == null ? q : p;
        while (k != null) {
            int num = k.val;
            int sum = num + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            k = k.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }
}
