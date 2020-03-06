package LeetCode206;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode reverseListByRecurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = reverseListByRecurse(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }

    public ListNode reverseListByIteration(ListNode head) {
        ListNode headReverse = null;
        if (head != null) {
            ListNode p = head;
            ListNode q = head.next;
            while (q != null) {
                ListNode temp = q.next;
                q.next = p;
                p = q;
                q = temp;
            }
            headReverse = p;
            head.next = null;
        }
        return headReverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        solution.reverseListByRecurse(head);
    }
}
